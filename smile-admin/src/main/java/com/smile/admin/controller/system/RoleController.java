package com.smile.admin.controller.system;

import com.smile.admin.bean.domain.Role;
import com.smile.admin.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/1/17
 * @description:
 */
@Controller
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("list")
    public String list() {
        return "system/role-list";
    }

    @GetMapping("data")
    @ResponseBody
    public List<Role> data() {
        return null;
    }

}
