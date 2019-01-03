package com.yiran.controller;


import com.yiran.pojo.User;
import com.yiran.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
* 控制器
* */

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String get() { // 用来返回一个页面
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(User user) { // 用来处理用户的登录请求
        System.out.println(user);
        if (loginService.login(user) != null) {
            return "login_success";
        }
        return "login";
    }

}
