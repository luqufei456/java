package com.yiran.mybatis.mapper;

import com.yiran.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据id查询
     *
     * @param user
     * @return
     */
    User queryUserById(User user);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    List<User> queryUserByUserName(String username);

    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);
}
