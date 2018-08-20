package com.yiran.spring.action;

import com.yiran.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.log4j.Logger;

@Component("userAction")
@Scope
public class UserAction {
    @Autowired
    private UserService userService;

    Logger logger = Logger.getLogger(UserService.class);

    public UserAction(){
        System.out.println("UserAction构造方法");
    }

    public void save(){
        logger.debug("debug开始");
        userService.save();
        logger.debug("debug结束");
    }

    // 初始化后自动调用方法：方法名随意，但也不能太随便，一会要配置
    @PostConstruct // 初始化的方法
    public void init(){
        System.out.println("初始化方法调用了");
    }

    // bean销毁时调用的方法
    @PreDestroy
    public void destroy(){
        System.out.println("销毁时调用");
    }
}
