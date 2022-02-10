package com.controller.admin;

import com.entity.Contracts;
import com.entity.Message;
import com.entity.Users;
import com.service.ContractsService;
import com.service.MessageService;
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
public class MessageController {
    @Resource
    private MessageService messageService;
    @Resource
    private UsersService userService;
    @Resource
    private ContractsService contractsService;

    public static final String TABLE_NAME = "预警";


    void commonMethod(ModelMap map){
        Map<String,Object> kMap =new HashMap<>();
        kMap.put("utype","客户");
        map.put("khlist",userService.getAll(kMap));
        map.put("ulist",userService.getAll(null));
    }


    /*处理添加预警表*/
    @RequestMapping("admin/doAddMessage.do")
    public String doAddContracts( HttpSession session,HttpServletRequest request, ModelMap map,int id) {
        Users users = (Users)session.getAttribute("auser");
        if (users==null){
            return "admin/login";
        }else {
            /*通用方法*/
            commonMethod(map);
            Contracts contracts = contractsService.getById(id);
            Users users1 = userService.getById(contracts.getClientid());
           map.put("contracts",contracts);
            map.put("usersKh",users1);
            map.put("usersYw",userService.getById(users.getId()));
        }
        return "admin/message_add";
    }

    /**
     * ===后台预警管理===
     *
     * @param request
     * @param session
     * @return
     */

    // 添加预警
    @RequestMapping("admin/addMessage.do")
    public String addMessage(HttpServletRequest request, Message message, HttpSession session) {
        Users user = (Users) session.getAttribute("auser");
        if (user==null){
            return "admin/login";
        }else {
            Timestamp time = new Timestamp(System.currentTimeMillis());
            message.setPubtime(time.toString().substring(0, 19));
        messageService.add(message);
        return "redirect:messageList.do";
        }
    }


    /*处理修改预警*/
    @RequestMapping("admin/doUpdateMessage.do")
    public String doUpdateMessage(HttpServletRequest request, int id, ModelMap map) {
        Message message = messageService.getById(id);
        map.put("usersKh",userService.getById(message.getJid()));
        map.put("usersYw",userService.getById(message.getFid()));
        map.put("message", message);
        return "admin/message_update";
    }

    /*保存预警*/
    @RequestMapping("admin/updateMessage.do")
    public String updateMessage(HttpServletRequest request, Message message, HttpSession session) {
        messageService.update(message);
        return "redirect:messageList.do";
    }


    // 分页查询预警信息的列表
    @RequestMapping("admin/messageList.do")
    public String messageList(@RequestParam(value = "page", defaultValue = "0") Integer page, ModelMap map,
                            HttpSession session) {
        Users user = (Users) session.getAttribute("auser");
        if (user==null){
            return "admin/login";
        }else {
            Map<String, Object> bMap = new HashMap<>();
            if (user.getUtype().equals("业务员")){
                bMap.put("fid",user.getId());
            }
            if (user.getUtype().equals("客户")){
                bMap.put("jid",user.getId());
            }
            List<Message> list = messageService.getAll(bMap);
            map.put("list", list);
            /*通用方法*/
            commonMethod(map);
            return "admin/message_list";
        }
    }


    /*删除预警*/
    @RequestMapping("admin/deleteMessage.do")
    public String deleteMessage(int id) {
        messageService.delete(id);
        return "redirect:messageList.do";
    }
}

