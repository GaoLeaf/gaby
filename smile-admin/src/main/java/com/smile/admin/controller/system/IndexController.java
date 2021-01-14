package com.smile.admin.controller.system;

import com.smile.admin.bean.dto.SecurityUser;
import com.smile.admin.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author gaowenjin
 * @date 2021/1/6
 * @description:
 */
@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping({"index", "/"})
    public String index(Model model) {

        // 获取用户信息
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            SecurityUser user = (SecurityUser) principal;
            String roles = user.getRoles();
        }

        Set<Integer> set = new HashSet<>();
        set.add(1);

        //TODO menu
        model.addAttribute("menus", menuService.getMenuListByRole(set));

        return "index";
    }

    // 主界面
    @GetMapping("main")
    public String main() {
        return "main";
    }

}
