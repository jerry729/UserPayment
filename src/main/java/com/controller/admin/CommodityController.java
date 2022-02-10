package com.controller.admin;

import com.entity.Commodity;
import com.entity.Users;
import com.service.CommodityService;
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
public class CommodityController {
    @Resource
    private CommodityService commodityService;

    public static final String TABLE_NAME = "货物表";

    /**
     * ===后台货物表管理===
     *
     * @param request
     * @param session
     * @return
     */

    // 添加货物表
    @RequestMapping("admin/addCommodity.do")
    public String addCommodity(HttpServletRequest request, Commodity commodity, HttpSession session) {
        Users user = (Users) session.getAttribute("auser");
        if (user==null){
            return "admin/login";
        }else {
        commodityService.add(commodity);
        return "redirect:commodityList.do";
        }
    }


    /*处理修改货物表*/
    @RequestMapping("admin/doUpdateCommodity.do")
    public String doUpdateCommodity(HttpServletRequest request, int id, ModelMap map) {
        map.put("commodity", commodityService.getById(id));
        return "admin/commodity_update";
    }

    /*保存货物表*/
    @RequestMapping("admin/updateCommodity.do")
    public String updateCommodity(HttpServletRequest request, Commodity commodity, HttpSession session) {
        commodityService.update(commodity);
        return "redirect:commodityList.do";
    }


    // 分页查询货物表信息的列表
    @RequestMapping("admin/commodityList.do")
    public String commodityList(@RequestParam(value = "page", defaultValue = "0") Integer page, ModelMap map,
                            HttpSession session) {
        Map<String, Object> bMap = new HashMap<>();
        List<Commodity> list = commodityService.getAll(bMap);
        map.put("list", list);
        return "admin/commodity_list";
    }


    /*删除货物表*/
    @RequestMapping("admin/deleteCommodity.do")
    public String deleteCommodity(int id) {
        commodityService.delete(id);
        return "redirect:commodityList.do";
    }
}

