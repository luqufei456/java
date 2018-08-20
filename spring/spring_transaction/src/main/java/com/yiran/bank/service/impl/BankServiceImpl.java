package com.yiran.bank.service.impl;

import com.yiran.bank.dao.BankDao;
import com.yiran.bank.service.BankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BankServiceImpl implements BankService {
    @Resource
    private BankDao bankDao;

    @Override
    public void saveMoney(String bankId, double money) {
        bankDao.saveMoney(bankId,money);
    }

    @Override
    public void transferMoney(String myBankId, String otherBankId, double money) {
        // 开启事务
        bankDao.moneyOut(myBankId,money);
        bankDao.moneyIn(otherBankId,money);
        // 提交事务，若其中有报错，则回滚
    }
}
