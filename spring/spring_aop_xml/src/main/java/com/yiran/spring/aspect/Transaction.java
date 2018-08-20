package com.yiran.spring.aspect;

public class Transaction {
    public void beginTransaction(){
        System.out.println("------开启事务------");
    }

    public void commit(){
        System.out.println("------提交事务------");
    }

    public void rollBack(){
        System.out.println("------回滚事务------");
    }
}
