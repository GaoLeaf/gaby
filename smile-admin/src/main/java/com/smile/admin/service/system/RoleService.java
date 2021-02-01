package com.smile.admin.service.system;

import com.smile.admin.bean.domain.Role;

import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/1/24
 * @description:
 */
public interface RoleService {

    /**
     * 根据角色Id集合获取角色信息
     * @param roleIds
     * @return
     */
    List<Role> getRoleListByIds(List<String> roleIds);

    /**
     * 保存或者修改角色
     * @param role
     * @return
     */
    int saveOrUpdate(Role role);

}
