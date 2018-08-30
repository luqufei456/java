package com.yiran.crm.service;

import com.yiran.crm.pojo.SysUser;
import com.yiran.crm.pojo.UserRoleVo;

public interface UserService {
    SysUser login(SysUser user);

    void addUser(UserRoleVo userRoleVo);

    String queryUserByCode(SysUser user);
}
