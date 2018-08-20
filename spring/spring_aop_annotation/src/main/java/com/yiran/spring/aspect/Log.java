package com.yiran.spring.aspect;

/*
*
* aspect类，切面类，就是正常的类
* */


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log {
    // advice通知，普通的方法，方法名随便，一会儿配置即可
    @Pointcut(value = "execution(* com.yiran.spring.service.impl.*.*(..))")
    public void puct(){}

    @AfterReturning(pointcut = "puct()")
    public void log(){
        System.out.println("------添加消息日志------");
        //System.out.println("方法名称"+joinPoint.getSignature().getName());
    }
}
