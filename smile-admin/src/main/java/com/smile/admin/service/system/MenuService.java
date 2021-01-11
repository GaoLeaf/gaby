package com.smile.admin.service.system;

import com.smile.admin.bean.domain.Menu;

import java.util.List;
import java.util.Set;

/**
 * @author gaowenjin
 * @date 2021/1/7
 * @description:
 */
public interface MenuService {

    // 获取角色已有菜单
    List<Menu> getMenuListByRole(Set<Integer> roleIds);

}
