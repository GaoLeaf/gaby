package com.smile.admin.common;

import com.smile.admin.bean.domain.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 菜单树形工具类
 * @Description:
 * @Author: leaf
 * @Since: 2019/3/21 15:11
 * @Version:1.1
 */
public class TreeUtils {

	/**
	 * 获取菜单
	 *
	 * @param menus
	 * @return
	 */
	public static List<Menu> getParentMenus(List<Menu> menus) {

		List<Menu> parentMenus = new ArrayList<>();

		// 遍历菜单，取出一级菜单
		for (Menu menu : menus) {

			if (menu.getParentId() == null) {
				parentMenus.add(menu);
			}

		}

		// 获取子菜单
		for (Menu menu : parentMenus) {

			menu.setChildMenus(getChildMenus(menus, menu));

		}

		return parentMenus;

	}

	/**
	 * 获取子菜单
	 *
	 * @param menus
	 * @param parentMenu
	 * @return
	 */
	public static List<Menu> getChildMenus(List<Menu> menus, Menu parentMenu) {

		List<Menu> childMenus = new ArrayList<>();

		for (Menu menu : menus) {
			if (parentMenu.getId().equals(menu.getParentId())) {
				childMenus.add(menu);
			}
		}

		return childMenus;

	}

}
