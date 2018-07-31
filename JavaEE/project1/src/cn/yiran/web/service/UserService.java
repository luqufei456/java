package cn.yiran.web.service;

import cn.yiran.web.dao.UserDAO;
import cn.yiran.web.dao.impl.UserDAOImpl;
import cn.yiran.web.domain.User;

public interface UserService {
    UserDAO userDAO = new UserDAOImpl();

    int register(User user);

    User login(User user);
}
