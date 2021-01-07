package com.smile.admin.controller.system;

import com.smile.admin.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        //TODO menu
        model.addAttribute("menus", menuService.getMenuListByRole(null));

        return "index";
    }

}
