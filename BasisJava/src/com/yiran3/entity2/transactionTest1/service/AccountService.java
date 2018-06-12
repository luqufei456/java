package com.yiran3.entity2.transactionTest1.service;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yiran3.entity2.transactionTest1.dao.AccountDao;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Service层： 调用者(Service)
 *    Service层：Service层主要负责业务模块的逻辑应用设计。
 * 同样是首先设计接口，再设计其实现的类，接着再Spring的配置文件中
 * 配置其实现的关联。这样我们就可以在应用中调用Service接口来进行业务处理。
 * Service层的业务实现，具体要调用到已定义的DAO层的接口，封装Service层
 * 的业务逻辑有利于通用的业务逻辑的独立性和重复利用性，程序显得非常简洁。
 * */

public class AccountService {
    // 定义dataSource、Connection
    // 使dao层不需要自己创建
    private AccountDao accountDao = new AccountDao();
    DataSource dataSource = null;
    Connection conn = null;

    /**
     * 业务层转账的方法：
     * from	:付款人
     * to	:收款人
     * money	:转账金额
      */
    public void transfer(String outUser, String inUser, double money){
        dataSource = new ComboPooledDataSource("yiranApp");
        try {
            // 获得数据连接
            conn = dataSource.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            // 创建dao对象
            AccountDao accountDao = new AccountDao();
            // 调用转入转出方法
            accountDao.out(conn, outUser, money);

            // 设置一个随机数 0或1来模拟是否停电
            // Math.random 在 [0,1)之间随机取值
            // Math.round()四舍五入
            long i = Math.round(Math.random());
            System.out.println(i);
            // 当i为0时，模拟停电
            long r = 1/i;

            accountDao.in(conn, inUser, money);

            // 提交
            conn.commit();
            System.out.println("提交成功，转账成功");
        } catch (Exception e){
            try {
                // 回滚
                if (conn != null)
                conn.rollback();
                System.out.println("遇到bug，事务回滚");
            } catch (Exception e1){
                System.out.println("连回滚都失败了~");
            }
        } finally {
            try {
                if (conn != null)
                conn.close();
            } catch (Exception e2) {
                System.out.println("释放资源失败");
            }
        }
    }
}
