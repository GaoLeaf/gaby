package com.smile.admin.mapper.system;

import com.smile.admin.bean.domain.RoleMenu;
import com.smile.admin.bean.domain.RoleMenuExample;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RoleMenuMapper {
    long countByExample(RoleMenuExample example);

    int deleteByExample(RoleMenuExample example);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    List<RoleMenu> selectByExampleWithRowbounds(RoleMenuExample example, RowBounds rowBounds);

    List<RoleMenu> selectByExample(RoleMenuExample example);

    // 查找角色已有菜单ID集合
    List<Integer> selectMemuIdsByRoleIds(@Param("roleIds") Set<String> roleIds);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);
}