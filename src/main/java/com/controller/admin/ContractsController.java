package com.controller.admin;

import com.entity.Commodity;
import com.entity.Contracts;
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
public class ContractsController {
    @Resource
    private ContractsService contractsService;
    @Resource
    private ClientsService clientsService;
    @Resource
    private SalesPersonService salesPersonService;
    @Resource
    private CommodityService commodityService;
    @Resource
    private UsersService userService;
    @Resource
    private BillsService billsService;

    public static final String TABLE_NAME = "合同表";


    void commonMethod(ModelMap map){
        Map<String,Object> kMap =new HashMap<>();
        kMap.put("utype","客户");
        map.put("khlist",userService.getAll(kMap));
        map.put("ywlist",salesPersonService.getAll(null));
        map.put("slist",commodityService.getAll(null));
        map.put("ulist",userService.getAll(null));
    }


    /*处理添加合同表*/
    @RequestMapping("admin/doAddContracts.do")
    public String doAddContracts( HttpSession session,HttpServletRequest request, ModelMap map) {
        Users users = (Users)session.getAttribute("auser");
        if (users==null){
            return "admin/login";
        }else {
            /*通用方法*/
            commonMethod(map);
            Map<String,Object> kMap = new HashMap<>();
            if (users.getUtype().equals("业务员")){
                kMap.put("utype","客户");
                kMap.put("cid",users.getId());
                map.put("khlist",userService.getAll(kMap));
            }
        }
        return "admin/contracts_add";
    }
    /**
     * ===后台合同表管理===
     *
     * @param request
     * @param session
     * @return
     */

    // 添加合同表
    @RequestMapping("admin/addContracts.do")
    public String addContracts(HttpServletRequest request, Contracts contracts, HttpSession session) {
        Users user = (Users) session.getAttribute("auser");
        if (user==null){
            return "admin/login";
        }else {
            Commodity commodity=commodityService.getById(contracts.getComid());
            double total=contracts.getComquant()*commodity.getUnitprice();
            commodity.setReserve(commodity.getReserve()-contracts.getComquant());
            commodityService.update(commodity);
            contracts.setAmount(total);
            contracts.setSpid(user.getId());
            Timestamp time = new Timestamp(System.currentTimeMillis());
            contracts.setPubtime(time.toString().substring(0, 19));
            contracts.setStatus("正常");
            contractsService.add(contracts);
            return "redirect:contractsList.do";
        }
    }


    /*处理修改合同表*/
    @RequestMapping("admin/doUpdateContracts.do")
    public String doUpdateContracts( HttpSession session,HttpServletRequest request, int id, ModelMap map) {
        Users users = (Users)session.getAttribute("auser");
        if (users==null){
            return "admin/login";
        }else {
            /*通用方法*/
            commonMethod(map);
            Map<String,Object> kMap = new HashMap<>();
            if (users.getUtype().equals("业务员")){
                kMap.put("utype","客户");
                kMap.put("cid",users.getId());
                map.put("khlist",userService.getAll(kMap));
            }
            map.put("contracts", contractsService.getById(id));
            return "admin/contracts_update";
        }
    }

    /*保存合同表*/
    @RequestMapping("admin/updateContracts.do")
    public String updateContracts(HttpServletRequest request, Contracts contracts, HttpSession session) {
        Commodity commodity=commodityService.getById(contracts.getComid());
        double total=contracts.getComquant()*commodity.getUnitprice();
        contracts.setAmount(total);
        commodity.setReserve(commodity.getReserve()-contracts.getComquant());
        commodityService.update(commodity);
        contractsService.update(contracts);
        return "redirect:contractsList.do";
    }


    // 分页查询合同表信息的列表
    @RequestMapping("admin/contractsList.do")
    public String contractsList(@RequestParam(value = "page", defaultValue = "0") Integer page, ModelMap map,
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
            List<Contracts> list = contractsService.getAll(bMap);
            map.put("list", list);
            /*通用方法*/
            commonMethod(map);
            return "admin/contracts_list";
        }
    }


    /*删除合同表*/
    @RequestMapping("admin/deleteContracts.do")
    public String deleteContracts(int id) {
        contractsService.delete(id);
        return "redirect:contractsList.do";
    }
}

