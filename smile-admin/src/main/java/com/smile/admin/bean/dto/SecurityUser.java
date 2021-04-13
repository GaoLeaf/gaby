package com.smile.admin.bean.dto;

import com.smile.admin.bean.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author gaowenjin
 * @date 2021/1/6
 * @description:
 */
public class SecurityUser extends User implements UserDetails {

    private static final long serialVersionUID = 1L;

    public SecurityUser(User user) {
        if (user != null) {
            this.setUserId(user.getUserId());
            this.setFamilyId(user.getFamilyId());
            this.setUsername(user.getUsername());
            this.setNickname(user.getNickname());
            this.setPassword(user.getPassword());
            this.setRoles(user.getRoles());
            this.setIsAccNonExpired(user.getIsAccNonExpired());
            this.setIsAccNonLocked(user.getIsAccNonLocked());
            this.setStatus(user.getStatus());
        }
    }

    /**
     * 已授予的权限列表
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 账号是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return this.getIsAccNonExpired();
    }

    /**
     * 账号是否锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.getIsAccNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
