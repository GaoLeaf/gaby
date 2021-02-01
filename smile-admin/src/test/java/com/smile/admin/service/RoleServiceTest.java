package com.smile.admin.service;

import com.smile.admin.bean.domain.Role;
import com.smile.admin.mock.MockApplication;
import com.smile.admin.service.system.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/2/1
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockApplication.class)
public class RoleServiceTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoleService roleService;

    @Test
    public void testGetRoleListByIds() {

        List<String> roleIds = Arrays.asList("1");

        List<Role> roles = roleService.getRoleListByIds(roleIds);

        logger.info("查询角色列表 {}", roles);

    }

}
