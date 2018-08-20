package com.yiran.bank.dao.impl;

import com.yiran.bank.dao.BankDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 1: 依赖注入配置的bean  jdbcTemplate
 * 2: extends JdbcDaoSupport
 */

@Repository
public class BankDaoImpl implements BankDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveMoney(String bankId, double money) {
        jdbcTemplate.update("UPDATE bankaccount SET balance = balance + ? WHERE bankId = ?",money,bankId);
    }

    @Override
    public void moneyOut(String myBankId, double money) {
        jdbcTemplate.update("UPDATE bankaccount SET balance = balance - ? WHERE bankId = ?",money,myBankId);
    }

    @Override
    public void moneyIn(String otherBankId, double money) {
        jdbcTemplate.update("UPDATE bankaccount SET balance = balance + ? WHERE bankId = ?",money,otherBankId);
        // throw new RuntimeException(); 也的确会回滚，完成测试~
    }
}
