package com.smile.admin.mapper;

import com.smile.admin.bean.domain.User;
import com.smile.admin.mapper.system.UserMapper;
import com.smile.admin.mock.MockApplication;
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
 * @date 2021/1/5
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockApplication.class)
public class UserMapperTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGetUser() {

        List<User> user = userMapper.getUser();

        logger.info("用户总数量: {}", user.size());

    }

}
