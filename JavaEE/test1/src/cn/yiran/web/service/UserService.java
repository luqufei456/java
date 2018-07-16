package cn.yiran.web.service;

import cn.yiran.web.dao.UserDAO;
import cn.yiran.web.dao.impl.UserDAOImpl;
import cn.yiran.web.domain.User;

import java.util.List;

/**
 * 业务层
 * */

public interface UserService {
    UserDAO userDAO = new UserDAOImpl();

    boolean register(User user);

    List<User> show();

    boolean login(User user);
}
