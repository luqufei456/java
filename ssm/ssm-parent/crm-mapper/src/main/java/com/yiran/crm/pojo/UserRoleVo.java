package com.yiran.crm.pojo;

import java.io.Serializable;
import java.util.List;

public class UserRoleVo implements Serializable {
    private SysUser user;
    private List<Integer> roleIds;

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}
