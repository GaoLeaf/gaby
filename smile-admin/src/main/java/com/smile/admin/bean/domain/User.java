package com.smile.admin.bean.domain;

import java.util.Date;
import java.util.Set;

/**
 * @Title:
 * @Description: 用户
 * @Author: leaf
 * @Since: 2019/3/20 14:49
 * @Version:1.1
 */
public class User {

	private static final long serialVersionUID = 1L;

	private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long ouId;

    private String familyId;

    private String username;

    private String nickname;

    private String password;

    private Set<String> roles;

    private String sex;

    private String birthday;

    private String email;

    private String mobile;

    private String phone;

    private String jobNumber;

    private String address;

    //用户帐号是否未过期，过期帐号无法登录系统
    private Boolean isAccNonExpired;

    //用户帐号是否未被锁定，被锁定的用户无法使用系统
    private Boolean isAccNonLocked;

//    private Status status;

    private Date createTime;

    private Date latestUpdateTime;

    private Date latestAccessTime;

    private String memo;

    public Long getOuId() {
        return ouId;
    }

    public void setOuId(Long ouId) {
        this.ouId = ouId;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getAccNonExpired() {
        return isAccNonExpired;
    }

    public void setAccNonExpired(Boolean accNonExpired) {
        isAccNonExpired = accNonExpired;
    }

    public Boolean getAccNonLocked() {
        return isAccNonLocked;
    }

    public void setAccNonLocked(Boolean accNonLocked) {
        isAccNonLocked = accNonLocked;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLatestUpdateTime() {
        return latestUpdateTime;
    }

    public void setLatestUpdateTime(Date latestUpdateTime) {
        this.latestUpdateTime = latestUpdateTime;
    }

    public Date getLatestAccessTime() {
        return latestAccessTime;
    }

    public void setLatestAccessTime(Date latestAccessTime) {
        this.latestAccessTime = latestAccessTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
