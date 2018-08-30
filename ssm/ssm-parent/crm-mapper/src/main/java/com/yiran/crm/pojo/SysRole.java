package com.yiran.crm.pojo;

import java.io.Serializable;

public class SysRole implements Serializable {
    private Long roleId;

    private String roleName;

    private String roleMemo;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo == null ? null : roleMemo.trim();
    }
}