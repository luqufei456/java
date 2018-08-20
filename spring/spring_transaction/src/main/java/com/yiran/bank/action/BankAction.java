package com.yiran.bank.action;

import com.yiran.bank.service.BankService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/* 控制层组件 */
@Controller
public class BankAction {
    @Resource
    private BankService bankService;

    public void saveMoney(String bankId,double money){
        bankService.saveMoney(bankId,money);
    }

    public void transferMoney(String myBankId,String otherBankId,double money){
        bankService.transferMoney(myBankId,otherBankId,money);
    }
}