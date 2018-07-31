package cn.yiran.web.service.impl;

import cn.yiran.web.domain.User;
import cn.yiran.web.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public int register(User user) {
        return userDAO.register(user);
    }

    @Override
    public User login(User user) {
        return userDAO.login(user);
    }
}
