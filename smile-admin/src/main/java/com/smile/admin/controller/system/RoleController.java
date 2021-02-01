package com.smile.admin.controller.system;

import com.smile.admin.bean.domain.Role;
import com.smile.admin.common.PrincipalUtils;
import com.smile.admin.service.system.RoleService;
import com.smile.tool.bean.dto.BackWarnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
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

    @PostMapping("data")
    @ResponseBody
    public List<Role> data() {
        return roleService.getRoleListByIds(new ArrayList<>(PrincipalUtils.roleIds()));
    }

    @GetMapping("add")
    public String add() {
        return "system/role-edit";
    }

    @GetMapping("edit/{roleId}")
    public String edit(@PathVariable("roleId") String roleId, Model model) {
        model.addAttribute("role", roleService.getRoleListByIds(Arrays.asList(roleId)).get(0));
        return "system/role-edit";
    }

    @PostMapping({"add", "edit"})
    public BackWarnEntity saveOrUpdate(Role role) {

        int result = roleService.saveOrUpdate(role);

        if (result > 0) {
            return new BackWarnEntity(true, "成功");
        } else {
            return new BackWarnEntity(false, "失败");
        }
    }

}
