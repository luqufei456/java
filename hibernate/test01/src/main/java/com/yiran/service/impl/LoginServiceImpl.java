package com.yiran.service.impl;

import com.yiran.dao.UserDao;
import com.yiran.pojo.User;
import com.yiran.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
