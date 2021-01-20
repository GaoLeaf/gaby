package com.smile.admin.controller.system;

import com.smile.admin.bean.domain.Menu;
import com.smile.admin.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaowenjin
 * @date 2021/1/17
 * @description:
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("list")
    public String list() {
        return "system/menu-list";
    }

    @PostMapping("data")
    @ResponseBody
    public List<Menu> data() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        return menuService.getMenuListByRole(set);
    }

}
