package com.yiran3.entity2.transactionTest1.domain;

import com.yiran3.entity2.transactionTest1.service.AccountService;

/**
 * 入口程序
 * */

public class AccountMain {
    public static void main(String[] args){
        // 1.定义参数
        String outUser = "chunjue";
        String inUser = "yiran";
        double money = 1000d;

        // 2.转账
        AccountService accountService = new AccountService();
        accountService.transfer(outUser,inUser,money);

        // 3.提示，我设置在service里提示
        //System.out.println("转账成功");

        // 4.付款和收款失败的提示定义在各自的方法中
        // 不使用事务，如果中途出错可能会导致存款丢失
    }
}
