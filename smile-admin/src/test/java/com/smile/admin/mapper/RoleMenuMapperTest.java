package com.smile.admin.mapper;

import com.smile.admin.bean.domain.RoleMenu;
import com.smile.admin.bean.domain.RoleMenuExample;
import com.smile.admin.mapper.system.RoleMenuMapper;
import com.smile.admin.mock.MockApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaowenjin
 * @date 2021/1/8
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockApplication.class)
public class RoleMenuMapperTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Test
    public void testSelectByExample() {

        RoleMenuExample example = new RoleMenuExample();

        List<Integer> roleIds = new ArrayList<>();
        roleIds.add(1);
        roleIds.add(2);

        example.createCriteria().andRoleIdIn(roleIds);

        roleMenuMapper.selectByExample(example);

    }

    @Test
    public void testSelectMenuIdsByRoleIds() {

        Set<String> roleIds = new HashSet<>();
        roleIds.add("1");

        List<Integer> menuIds = roleMenuMapper.selectMemuIdsByRoleIds(roleIds);

        logger.info("菜单ID {}", menuIds);
    }

}
