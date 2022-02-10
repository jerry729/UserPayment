package com.controller.admin;

import com.entity.Clients;
import com.entity.Users;
import com.service.ClientsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClientsController {
    @Resource
    private ClientsService clientsService;

    public static final String TABLE_NAME = "客户表";

    /**
     * ===后台客户表管理===
     *
     * @param request
     * @param session
     * @return
     */

    // 添加客户表
    @RequestMapping("admin/addClients.do")
    public String addClients(HttpServletRequest request, Clients clients, HttpSession session) {
        Users user = (Users) session.getAttribute("auser");
        if (user==null){
            return "admin/login";
        }else {
        clientsService.add(clients);
        return "redirect:clientsList.do";
        }
    }


    /*处理修改客户表*/
    @RequestMapping("admin/doUpdateClients.do")
    public String doUpdateClients(HttpServletRequest request, int id, ModelMap map) {
        map.put("clients", clientsService.getById(id));
        return "admin/clients_update";
    }

    /*保存客户表*/
    @RequestMapping("admin/updateClients.do")
    public String updateClients(HttpServletRequest request, Clients clients, HttpSession session) {
        clientsService.update(clients);
        return "redirect:clientsList.do";
    }


    // 分页查询客户表信息的列表
    @RequestMapping("admin/clientsList.do")
    public String clientsList(@RequestParam(value = "page", defaultValue = "0") Integer page, ModelMap map,
                            HttpSession session) {

        Map<String, Object> bMap = new HashMap<>();
        List<Clients> list = clientsService.getAll(bMap);
        map.put("list", list);
        return "admin/clients_list";
    }


    /*删除客户表*/
    @RequestMapping("admin/deleteClients.do")
    public String deleteClients(int id) {
        clientsService.delete(id);
        return "redirect:clientsList.do";
    }
}

