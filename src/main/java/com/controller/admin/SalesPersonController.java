package com.controller.admin;

import com.entity.SalesPerson;
import com.entity.Users;
import com.service.SalesPersonService;
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
public class SalesPersonController {
    @Resource
    private SalesPersonService salesPersonService;

    public static final String TABLE_NAME = "业务员表";

    /**
     * ===后台业务员表管理===
     *
     * @param request
     * @param session
     * @return
     */

    // 添加业务员表
    @RequestMapping("admin/addSalesPerson.do")
    public String addSalesPerson(HttpServletRequest request, SalesPerson salesPerson, HttpSession session) {
        Users user = (Users) session.getAttribute("auser");
        if (user==null){
            return "admin/login";
        }else {
        salesPersonService.add(salesPerson);
        return "redirect:salesPersonList.do";
        }
    }


    /*处理修改业务员表*/
    @RequestMapping("admin/doUpdateSalesPerson.do")
    public String doUpdateSalesPerson(HttpServletRequest request, int id, ModelMap map) {
        map.put("salesPerson", salesPersonService.getById(id));
        return "admin/salesPerson_update";
    }

    /*保存业务员表*/
    @RequestMapping("admin/updateSalesPerson.do")
    public String updateSalesPerson(HttpServletRequest request, SalesPerson salesPerson, HttpSession session) {
        salesPersonService.update(salesPerson);
        return "redirect:salesPersonList.do";
    }


    // 分页查询业务员表信息的列表
    @RequestMapping("admin/salesPersonList.do")
    public String salesPersonList(@RequestParam(value = "page", defaultValue = "0") Integer page, ModelMap map,
                            HttpSession session) {

        Map<String, Object> bMap = new HashMap<>();
        List<SalesPerson> list = salesPersonService.getAll(bMap);
        map.put("list", list);
        return "admin/salesPerson_list";
    }


    /*删除业务员表*/
    @RequestMapping("admin/deleteSalesPerson.do")
    public String deleteSalesPerson(int id) {
        salesPersonService.delete(id);
        return "redirect:salesPersonList.do";
    }
}

