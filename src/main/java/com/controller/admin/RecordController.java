package com.controller.admin;

import com.entity.Bills;
import com.entity.Contracts;
import com.entity.Record;
import com.entity.Users;
import com.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RecordController {
    @Resource
    private RecordService recordService;
    @Resource
    private ClientsService clientsService;
    @Resource
    private SalesPersonService salesPersonService;
    @Resource
    private CommodityService commodityService;
    @Resource
    private BillsService billsService;
    @Resource
    private ContractsService contractsService;
    @Resource
    private UsersService userService;

    public static final String TABLE_NAME = "回款记录表";

    void commonMethod(ModelMap map){
        map.put("blist",billsService.getAll(null));
        map.put("htlist",contractsService.getAll(null));
        map.put("ulist",userService.getAll(null));

    }


    /*处理添加合同表*/
    @RequestMapping("admin/doAddRecord.do")
    public String doAddRecord(HttpServletRequest request, ModelMap map,int id) {
        Bills bills = billsService.getById(id);
        Contracts contracts=contractsService.getById(bills.getCtrctid());
        map.put("bills",bills);
        map.put("contracts",contracts);
        /*通用方法*/
        commonMethod(map);
        return "admin/record_add";
    }

    /**
     * ===后台回款记录表管理===
     *
     * @param request
     * @param session
     * @return
     */

    // 添加回款记录表
    @RequestMapping("admin/addRecord.do")
    public String addRecord(HttpServletRequest request, Record record, HttpSession session) {
        Users user = (Users) session.getAttribute("auser");
        if (user==null){
            return "admin/login";
        }else {
            Bills bills = billsService.getById(record.getBillid());
            record.setClientid(bills.getClientid());
            record.setSpid(bills.getSpid());
            record.setStatus("待审核");
            Timestamp time = new Timestamp(System.currentTimeMillis());
            record.setPubtime(time.toString().substring(0, 19));
            recordService.add(record);
            return "redirect:recordList.do";
        }
    }


    /*通过审核*/
    @RequestMapping("admin/record_tg.do")
    public String record_tg(HttpServletRequest request, int id, ModelMap map) {
        Record record =recordService.getById(id);
        Bills bills = billsService.getById(record.getBillid());
        Contracts contracts=contractsService.getById(record.getCtrctid());
        double money=bills.getArrear()-record.getRcrdquant();
        if (money<=0){
            contracts.setStatus("已还清");
            contractsService.update(contracts);
        }
        bills.setArrear(money);
        if (bills.getRepayt()==null||bills.getRepayt()==0){
            bills.setRepayt(1);
        }else {
            bills.setRepayt(bills.getRepayt()+1);
        }
        billsService.update(bills);
        record.setStatus("通过审核");
        recordService.update(record);
        return "redirect:recordList.do";
    }

    /*未通过审核*/
    @RequestMapping("admin/record_btg.do")
    public String record_btg(HttpServletRequest request, int id, ModelMap map) {
        Record record =recordService.getById(id);
        record.setStatus("通过审核");
        recordService.update(record);
        return "redirect:recordList.do";
    }

    /*处理修改回款记录表*/
    @RequestMapping("admin/doUpdateRecord.do")
    public String doUpdateRecord(HttpServletRequest request, int id, ModelMap map) {
        Record record =recordService.getById(id);
        Bills bills = billsService.getById(record.getBillid());
        Contracts contracts=contractsService.getById(record.getCtrctid());
        map.put("bills",bills);
        map.put("contracts",contracts);
        map.put("record", recordService.getById(id));
        return "admin/record_update";
    }

    /*保存回款记录表*/
    @RequestMapping("admin/updateRecord.do")
    public String updateRecord(HttpServletRequest request, Record record, HttpSession session) {
        recordService.update(record);
        return "redirect:recordList.do";
    }


    // 分页查询回款记录表信息的列表
    @RequestMapping("admin/recordList.do")
    public String recordList(@RequestParam(value = "page", defaultValue = "0") Integer page, ModelMap map,
                            HttpSession session) {
        Users user = (Users) session.getAttribute("auser");
        if (user==null){
            return "admin/login";
        }else {
            Map<String, Object> bMap = new HashMap<>();
            if (user.getUtype().equals("业务员")){
                bMap.put("spid",user.getId());
            }
            if (user.getUtype().equals("客户")){
                bMap.put("clientid",user.getId());
            }
            List<Record> list = recordService.getAll(bMap);
            map.put("list", list);
            /*通用方法*/
            commonMethod(map);
            return "admin/record_list";
        }
    }


    /*删除回款记录表*/
    @RequestMapping("admin/deleteRecord.do")
    public String deleteRecord(int id) {
        recordService.delete(id);
        return "redirect:recordList.do";
    }
}

