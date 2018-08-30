package com.yiran.mybatis.service.impl;

import com.yiran.mybatis.mapper.UserMapper;
import com.yiran.mybatis.pojo.User;
import com.yiran.mybatis.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional // 事务注解
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true) // 只读
    public User queryUserById(int userId) {
        return userMapper.queryUserById(userId);
    }
}
