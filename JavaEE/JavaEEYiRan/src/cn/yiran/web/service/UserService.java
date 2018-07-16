package cn.yiran.web.service;

import cn.yiran.web.dao.UserDAO;
import cn.yiran.web.domain.User;

/**
 * 封装对用户进行操作的业务逻辑
 * */

public class UserService {
    private UserDAO userDAO = new UserDAO();

    // 实现用户登录的业务逻辑
    public User login(User user){
        return userDAO.login(user);
    }

    public int register(User user){
        return userDAO.register(user);
    }
}