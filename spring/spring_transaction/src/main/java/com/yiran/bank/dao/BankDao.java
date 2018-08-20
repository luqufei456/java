package com.yiran.bank.dao;

public interface BankDao {
    void saveMoney(String bankId,double money);

    void moneyOut(String myBankId,double money);

    void moneyIn(String otherBankId,double money);
}
