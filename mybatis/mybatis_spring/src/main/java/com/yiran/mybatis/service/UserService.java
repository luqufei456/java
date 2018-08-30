package com.yiran.mybatis.service;

import com.yiran.mybatis.pojo.User;

public interface UserService {
    User queryUserById(int userId);
}
