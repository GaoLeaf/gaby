package com.smile.admin.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gaowenjin
 * @date 2021/1/6
 * @description:
 */
@Controller
public class IndexController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

}
