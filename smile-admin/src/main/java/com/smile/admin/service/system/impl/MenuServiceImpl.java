package com.smile.admin.service.system.impl;

import com.smile.admin.bean.domain.Menu;
import com.smile.admin.bean.domain.MenuExample;
import com.smile.admin.bean.domain.RoleMenu;
import com.smile.admin.bean.domain.RoleMenuExample;
import com.smile.admin.common.TreeUtils;
import com.smile.admin.mapper.system.MenuMapper;
import com.smile.admin.mapper.system.RoleMenuMapper;
import com.smile.admin.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author gaowenjin
 * @date 2021/1/7
 * @description:
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    public List<Menu> getMenuListByRole(Set<Integer> roleIds) {

        // 查询角色菜单集合
        RoleMenuExample roleMenuExample = new RoleMenuExample();
//        roleMenuExample.createCriteria().andRoleIdIn(roleIds);

        List<RoleMenu> roleMenus = roleMenuMapper.selectByExample(roleMenuExample);

        if (roleMenus.isEmpty()) {
            return Collections.emptyList();
        }

        // 查询菜单集合
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria()
                .andIdIn(roleMenus.stream()
                        .map(menu -> menu.getMenuId())
                        .collect(Collectors.toList())
                );
        menuExample.setOrderByClause("priority"); // 排序

        List<Menu> menus = menuMapper.selectByExample(menuExample);

        return TreeUtils.getParentMenus(menus);
    }

}
