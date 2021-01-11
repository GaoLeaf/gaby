package com.smile.admin.service.system.impl;

import com.smile.admin.bean.domain.Menu;
import com.smile.admin.bean.domain.MenuExample;
import com.smile.admin.common.TreeUtils;
import com.smile.admin.mapper.system.MenuMapper;
import com.smile.admin.mapper.system.RoleMenuMapper;
import com.smile.admin.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

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
        List<Integer> menuIds = roleMenuMapper.selectMemuIdsByRoleIds(roleIds);

        if (menuIds.isEmpty()) {
            return Collections.emptyList();
        }

        // 查询菜单集合
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andIdIn(menuIds);
        menuExample.setOrderByClause("priority"); // 排序

        List<Menu> menus = menuMapper.selectByExample(menuExample);

        return TreeUtils.getParentMenus(menus);
    }

}
