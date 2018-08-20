package com.yiran.spring.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Transaction {
    @Pointcut(value = "execution(* com.yiran.spring.service.impl.*.add*(..)) or" +
                      "execution(* com.yiran.spring.service.impl.*.update*(..)) or" +
                      "execution(* com.yiran.spring.service.impl.*.delete*(..))")
    public void tuct(){}

    @Before(value = "tuct()")
    public void beginTransaction(){
        System.out.println("------开启事务------");
    }

    /* 这里 value 和切入点pointcut都一样。 */
    @AfterReturning(value = "tuct()")
    public void commit(){
        System.out.println("------提交事务------");
    }

    @AfterThrowing(pointcut = "tuct()")
    public void rollBack(){
        System.out.println("------回滚事务------");
    }
}
