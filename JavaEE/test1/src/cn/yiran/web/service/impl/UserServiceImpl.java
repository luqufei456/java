package cn.yiran.web.service.impl;

import cn.yiran.web.dao.UserDAO;
import cn.yiran.web.domain.User;
import cn.yiran.web.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{
    public boolean register(User user){
        User findByName = userDAO.findByName(user.getName());
        if (findByName == null){
            int i = userDAO.register(user);
            if (i == 0){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    public List<User> show(){
        return userDAO.show();
    }

    public boolean login(User user){
        User loginUser = userDAO.login(user);
        if (loginUser == null){
            return false;
        }
        return true;
    }
}
