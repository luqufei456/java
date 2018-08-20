package com.yiran.spring.service.impl;

import com.yiran.spring.dao.UserDAO;
import com.yiran.spring.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    /* 若使用构造器实现DI，必须定义无参构造器 */
    public UserServiceImpl(){}

    /* 不然有参构造器存在时，缺省无参构造器就被忽略了。 */
    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void login(){
        System.out.println("UserServiceImpl");
        userDAO.login();
    }
}
