package com.controller.admin;

import com.entity.Bills;
import com.entity.Contracts;
import com.entity.Users;
import com.service.BillsService;
import com.service.ClientsService;
import com.service.ContractsService;
import com.service.UsersService;
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
public class BillsController {
    @Resource
    private BillsService billsService;
    @Resource
    private ContractsService contractsService;
    @Resource
    private ClientsService clientsService;
    @Resource
    private UsersService userService;

    public static final String TABLE_NAME = "账单表";

    void commonMethod(ModelMap map){
        map.put("hlist",contractsService.getAll(null));
        map.put("klist",clientsService.getAll(null));
        map.put("ulist",userService.getAll(null));
        map.put("htlist",contractsService.getAll(null));
    }

    /**
     * ===后台账单表管理===
     *
     * @param request
     * @return
     */

    /*处理添加账单表*/
    @RequestMapping("admin/doAddBills.do")
    public String doAddBills(HttpServletRequest request, ModelMap map,int id) {
        /*通用方法*/
        commonMethod(map);
        return "admin/bills_add";
    }

    // 添加账单表
    @RequestMapping("admin/addBills.do")
    public String addBills(HttpServletRequest request, int id, HttpSession session) {
        Users user = (Users) session.getAttribute("auser");
        if (user==null){
            return "admin/login";
        }else {
            Contracts contracts = contractsService.getById(id);
            Bills bills=new Bills();
            bills.setArrear(contracts.getAmount());
            bills.setClientid(contracts.getClientid());
            bills.setCtrctid(id);
            bills.setPubtime(new Timestamp(System.currentTimeMillis()).toString().substring(0,19));
            bills.setRepayt(0);
            bills.setSpid(contracts.getSpid());
            contracts.setStatus("待还款");
            contractsService.update(contracts);
            billsService.add(bills);
            return "redirect:billsList.do";
        }
    }


    /*处理修改账单表*/
    @RequestMapping("admin/doUpdateBills.do")
    public String doUpdateBills(HttpServletRequest request, int id, ModelMap map) {
        map.put("bills", billsService.getById(id));
        return "admin/bills_update";
    }

    /*保存账单表*/
    @RequestMapping("admin/updateBills.do")
    public String updateBills(HttpServletRequest request, Bills bills, HttpSession session) {
        billsService.update(bills);
        return "redirect:billsList.do";
    }


    // 分页查询账单表信息的列表
    @RequestMapping("admin/billsList.do")
    public String billsList(@RequestParam(value = "page", defaultValue = "0") Integer page, ModelMap map,
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
            List<Bills> list = billsService.getAll(bMap);
            map.put("list", list);
            /*通用方法*/
            commonMethod(map);
            return "admin/bills_list";
        }
    }


    /*删除账单表*/
    @RequestMapping("admin/deleteBills.do")
    public String deleteBills(int id) {
        billsService.delete(id);
        return "redirect:billsList.do";
    }
}

