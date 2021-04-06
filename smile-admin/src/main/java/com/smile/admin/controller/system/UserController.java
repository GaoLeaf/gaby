package com.smile.admin.controller.system;

import com.smile.admin.bean.domain.User;
import com.smile.admin.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/2/2
 * @description:
 */
@Controller
@RequestMapping("system/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public String list() {
        return "system/user-list";
    }

    @PostMapping("data")
    @ResponseBody
    public List<User> data() {
        return userService.getAll();
    }

}
