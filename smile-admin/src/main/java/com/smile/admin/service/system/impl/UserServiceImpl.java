package com.smile.admin.service.system.impl;

import com.smile.admin.bean.domain.User;
import com.smile.admin.bean.domain.UserExample;
import com.smile.admin.mapper.system.UserMapper;
import com.smile.admin.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/3/4
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        UserExample userExample = new UserExample();
        return userMapper.selectByExample(userExample);
    }

}
