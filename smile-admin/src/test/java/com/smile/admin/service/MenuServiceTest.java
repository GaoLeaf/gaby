package com.smile.admin.service;

import com.smile.admin.bean.domain.Menu;
import com.smile.admin.mock.MockApplication;
import com.smile.admin.service.system.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/1/7
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockApplication.class)
public class MenuServiceTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    @Test
    public void testGetMenuListByRole() {

        List<Menu> menus = menuService.getMenuListByRole(null, true);

        logger.info("菜单数量 {}", menus.size());
    }

}
