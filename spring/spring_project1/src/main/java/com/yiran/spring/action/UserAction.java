package com.yiran.spring.action;

import com.yiran.spring.service.UserService;

public class UserAction {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserAction(){
        System.out.println("构造");
    }

    public void login(){
        userService.login();
    }

    public void init(){
        System.out.println("执行初始化");
    }

    public void destroy(){
        System.out.println("销毁对象");
    }
}
