package com.yiran.ssm.service;

import com.github.pagehelper.PageInfo;
import com.yiran.ssm.pojo.SysUser;

public interface UserService {
    SysUser login(SysUser user);

    PageInfo<SysUser> queryList();
}
