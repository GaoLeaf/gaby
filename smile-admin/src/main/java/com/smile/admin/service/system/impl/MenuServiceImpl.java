package com.smile.admin.service.system.impl;

import com.smile.admin.bean.domain.Menu;
import com.smile.admin.bean.domain.MenuExample;
import com.smile.admin.common.TreeUtils;
import com.smile.admin.mapper.system.MenuMapper;
import com.smile.admin.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Menu> getMenuListByRole(Set<Integer> roleIds) {

        MenuExample menuExample = new MenuExample();

        List<Menu> menus = menuMapper.selectByExample(menuExample);

        return TreeUtils.getParentMenus(menus);
    }

}
