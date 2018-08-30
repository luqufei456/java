package com.yiran.mybatis.dao;

import com.yiran.mybatis.pojo.User;

public interface UserDao {
    User login(User user)  throws Exception;
}
