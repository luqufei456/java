package com.yiran.bank.service;

public interface BankService {
    void saveMoney(String bankId,double money);

    void transferMoney(String myBankId,String otherBankId,double money);
}
