package com.controller.admin;

import com.entity.${Domain};
import com.entity.Users;
import com.service.${Domain}Service;
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
public class ${Domain}ForeController {
    @Resource
    private ${Domain}Service ${domain}Service;

    public static final String TABLE_NAME = "${tableNameCn}";

    /*通用方法*/
    public void commonMethod(ModelMap map){

    }

    /**
     * ===前台${tableNameCn}管理===
     *
     * @param request
     * @param session
     * @return
     */

    // 添加${tableNameCn}
    @RequestMapping("add${Domain}.do")
    public String add${Domain}(HttpServletRequest request, ${Domain} ${domain}, HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        if (user==null){
            return "login";
        }else {
        ${domain}Service.add(${domain});
        return "redirect:${domain}List.do";
        }
    }


    /*处理修改${tableNameCn}*/
    @RequestMapping("doUpdate${Domain}.do")
    public String doUpdate${Domain}(HttpServletRequest request, int id, ModelMap map) {
        map.put("${domain}", ${domain}Service.getById(id));
        /*通用方法*/
        commonMethod(map);
        return "${domain}_update";
    }

    /*保存${tableNameCn}*/
    @RequestMapping("update${Domain}.do")
    public String update${Domain}(HttpServletRequest request, ${Domain} ${domain}, HttpSession session) {
        ${domain}Service.update(${domain});
        return "redirect:${domain}List.do";
    }


    // 分页查询${tableNameCn}信息的列表
    @RequestMapping("${domain}List.do")
    public String ${domain}List(@RequestParam(value = "page", defaultValue = "0") Integer page, ModelMap map,
                            HttpSession session) {

        Map<String, Object> bMap = new HashMap<>();
        List<${Domain}> list = ${domain}Service.getAll(bMap);
        map.put("list", list);
        /*通用方法*/
        commonMethod(map);
        return "${domain}_list";
    }

    // 分页查询${tableNameCn}信息的列表--模糊查询
    @RequestMapping("${domain}ListSearch.do")
    public String ${domain}ListSearch(@RequestParam(value = "page", defaultValue = "0") Integer page, ModelMap map,
                                  HttpSession session, ${Domain} ${domain}) {
        Map<String, Object> bMap = new HashMap<>();
        <#list fieldList as field>
        if (${domain}.get${field.nameBigHump}() != null && !${domain}.get${field.nameBigHump}().equals("")) {
            bMap.put("${field.nameHump}",${domain}.get${field.nameBigHump}());
        }
        </#list>
        List<${Domain}> list = ${domain}Service.getAll(bMap);
        map.put("list", list);
        /*通用方法*/
        commonMethod(map);
        return "${domain}_list";
    }

    /*删除${tableNameCn}*/
    @RequestMapping("delete${Domain}.do")
    public String delete${Domain}(int id) {
        ${domain}Service.delete(id);
        return "redirect:${domain}List.do";
    }
}

