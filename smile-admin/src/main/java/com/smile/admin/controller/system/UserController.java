package com.smile.admin.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gaowenjin
 * @date 2021/2/2
 * @description:
 */
@Controller
@RequestMapping("system/user")
public class UserController {

    @GetMapping("list")
    public String list() {
        return "list-bak";
    }

}
