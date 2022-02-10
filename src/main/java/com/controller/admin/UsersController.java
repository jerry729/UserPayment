package com.controller.admin;

import com.entity.Users;
import com.service.UsersService;
import com.util.Info;
import net.sf.json.JSONObject;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    @Resource
    private UsersService userService;

    /**
     * ====后台用户管理====
     *
     * @param user
     * @param session
     * @return
     */

    // 后台登录
    @RequestMapping("admin/alogin.do")
    public void checkLogin(Users user, HttpSession session, HttpServletResponse response) {
        Map<String, Object> u = new HashMap<String, Object>();
        System.out.println("name===" + user.getUname());
        System.out.println("pwd===" + user.getPwd());
        System.out.println("utype===" + user.getUtype());
        u.put("uname", user.getUname());
        u.put("utype", user.getUtype());
        u.put("pwd", user.getPwd());

        user = userService.adminLogin(u);
        JSONObject obj = new JSONObject();
        if (user == null) {
            obj.put("info", "ng");
        } else {
//				将用户账号存到session中
            System.out.println("33==" + user);
            session.setAttribute("auser", user);
            System.out.println("登录验证成功！");
            obj.put("info", "ok");
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(obj);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }


    /*个人信息*/
    @RequestMapping("admin/showUserInfo.do")
    public String showUserInfo(ModelMap map, HttpSession session) {
        if (session.getAttribute("auser") == null) {
            return "login";
        }
        Users u = (Users) session.getAttribute("auser");
        map.put("user", userService.getById(u.getId()));
        return "admin/update_user_person";
    }

    /*保存个人信息*/
    @RequestMapping("admin/updatePersonUser.do")
    public String updateUserInfo(ModelMap map, @RequestParam(value = "file", required = false) MultipartFile file,
                                 Users user, HttpSession session, String img, HttpServletRequest request) {
        img = Info.fileUpload(file, request, img);
        if (img != null) {
            user.setImg(img);
        }
        userService.update(user);
        map.put("user", userService.getById(user.getId()));
        session.setAttribute("suc", "cc");
        return "redirect:showUserInfo.do";
    }

    // 验证用户名是否存在
    @RequestMapping("admin/checkUname.do")
    public void checkUname(Users user, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        map.put("uname", user.getUname());
        System.out.println("uname===" + user.getUname());
        System.out.println("uname222===" + userService.checkUname(map));
        JSONObject obj = new JSONObject();
        if (userService.checkUname(map) != null) {
            obj.put("info", "ng");
        } else {
            obj.put("info", "用户名可以用！");
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(obj);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    // 添加用户
    @RequestMapping("admin/addUser.do")
    public String addUser(@RequestParam(value = "file", required = false) MultipartFile file,
                          Users user, HttpSession session, String img, HttpServletRequest request) {
        Users user1 = (Users) session.getAttribute("auser");
        if (user1!=null){
            img = Info.fileUpload(file, request, img);
            user.setImg(img);
            Timestamp time = new Timestamp(System.currentTimeMillis());
            user.setPubtime(time.toString().substring(0, 19));
            user.setStatus("正常");
            user.setCid(user1.getCid());
            userService.add(user);
            session.setAttribute("info", "添加成功！");
            return "admin/success";
        }else {
            return "admin/login";
        }
    }



    // 添加用户
    @RequestMapping("admin/addUser_kh.do")
    public String addUser_kh(@RequestParam(value = "file", required = false) MultipartFile file,
                          Users user, HttpSession session, String img, HttpServletRequest request) {
        Users users = (Users)session.getAttribute("auser");
        if (users==null){
            return "admin/login";
        }else {
            img = Info.fileUpload(file, request, img);
            user.setCid(users.getId());
            user.setImg(img);
            Timestamp time = new Timestamp(System.currentTimeMillis());
            user.setPubtime(time.toString().substring(0, 19));
            user.setStatus("正常");
            userService.add(user);
            session.setAttribute("info", "添加成功！");
            return "admin/success";
        }

    }


    // 处理更新用户的信息
    @RequestMapping("admin/doUpdateUser.do")
    public String doUpdateUser(ModelMap map, int id) {
        System.out.println("id==" + id);
        map.put("user", userService.getById(id));
        return "admin/user_update";
    }


    /*查看*/
    @RequestMapping("admin/user_look.do")
    public String user_look(ModelMap map, int id) {
        System.out.println("id==" + id);
        map.put("user", userService.getById(id));
        return "admin/user_look";
    }



    // 更新用户的信息
    @RequestMapping("admin/updateUser.do")
    public String updateUser(@RequestParam(value = "file", required = false) MultipartFile file,
                             Users user, HttpSession session, String img, HttpServletRequest request) {
        img = Info.fileUpload(file, request, img);
        if (img != null) {
            user.setImg(img);
        }
        userService.update(user);
        session.setAttribute("info", "更新成功！");
        return "admin/success";
    }


    // 查询所有用户的信息
    @RequestMapping("admin/userList.do")
    public String userList(HttpSession session, ModelMap map) {
        Map<String, Object> pmap = new HashMap<String, Object>();
        pmap.put("utype", "业务员");
        List<Users> list = userService.getAll(pmap);
        map.put("list", list);
        session.setAttribute("p", 1);
        return "admin/user_list";
    }


    // 查询所有客户的信息
    @RequestMapping("admin/userList_kh.do")
    public String userList_kh(HttpSession session, ModelMap map) {
        Users user1 = (Users) session.getAttribute("auser");
        if (user1==null){
            return "admin/login";
        }else{
            Map<String, Object> pmap = new HashMap<String, Object>();
            pmap.put("utype", "客户");
            if (user1.getUtype().equals("业务员")){
                pmap.put("cid",user1.getId());
            }
            List<Users> list = userService.getAll(pmap);
            map.put("list", list);
            map.put("ulist",userService.getAll(null));
            session.setAttribute("p", 1);
            return "admin/user_list_kh";
        }

    }


    @RequestMapping("admin/deleteUser.do")
    public String deleteUser(int id, HttpSession session) {
        userService.delete(id);
        session.setAttribute("info", "删除成功！");
        return "admin/success";
    }


    // 后台注销登录
    @RequestMapping("admin/loginOut.do")
    public String adminLoginOut(HttpSession session) {
        session.removeAttribute("auser");
        return "admin/login";
    }


}
