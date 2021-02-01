package com.smile.admin.service.system.impl;

import com.smile.admin.bean.domain.Role;
import com.smile.admin.bean.domain.RoleExample;
import com.smile.admin.common.PrincipalUtils;
import com.smile.admin.mapper.system.RoleMapper;
import com.smile.admin.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/1/24
 * @description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleListByIds(List<String> roleIds) {

        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleIdIn(roleIds);

        return roleMapper.selectByExample(roleExample);
    }

    @Override
    public int saveOrUpdate(Role role) {

        role.setModifyUserId(PrincipalUtils.id());
        role.setModifyUserName(PrincipalUtils.name());
        role.setModifyTime(new Date());
        if (role.getRoleId() == null) {
            role.setCreateUserId(PrincipalUtils.id());
            role.setCreateUserName(PrincipalUtils.name());
            role.setCreateTime(new Date());
            return roleMapper.insert(role);
        } else {
            RoleExample roleExample = new RoleExample();
            return roleMapper.updateByExampleSelective(role, roleExample);
        }

    }

}
