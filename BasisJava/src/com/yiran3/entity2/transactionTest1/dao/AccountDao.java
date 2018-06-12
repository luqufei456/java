package com.yiran3.entity2.transactionTest1.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * DAO层：  被调用者(Dao)
 *    DAO层主要是做数据持久层的工作，负责与数据库进行联络的一些任务都封装在此，
 * DAO层的设计首先是设计DAO的接口，然后在Spring的配置文件中定义此接口的实现类，
 * 然后就可在模块中调用此接口来进行数据业务的处理，而不用关心此接口的具体实现类是哪个类，
 * 显得结构非常清晰，DAO层的数据源配置，以及有关数据库连接的参数都在Spring的配置文件中进行配置。
 * */

public class AccountDao {
    // 定义几个私有属性，这里使用service传入的数据库连接
    // private DataSource dataSource = null;
    // private Connection conn = null;
    private PreparedStatement ps = null;

    // 创建dao对象时，初始化，得到dataSource数据源，
    // 从而获得QueryRunner查询生成器
    public AccountDao(){
        /*try {
            dataSource = new ComboPooledDataSource("yiranApp");
            conn = dataSource.getConnection();
        } catch (Exception e){
            e.printStackTrace();
        }*/
    }

    /**
     * 付款方法
     * */
    public void out(Connection conn,String outUser, double money) {
        try {
            // 这里是 -
            String outMoneySQL = "update account set money=money-? where name=?";
            Object[] params = {money, outUser};
            // 预处理
            ps = conn.prepareStatement(outMoneySQL);
            // 设置参数
            for (int i = 0;i < params.length;i++){
                ps.setObject(i+1,params[i]);
            }
            int result = ps.executeUpdate();
            System.out.println("影响了"+result+"行");
        } catch (Exception e){
            System.out.println("付款失败");
        } finally {
            // 释放资源，这里不释放conn，因为事务使用的是同一个数据库连接，
            // 在后面定义一个专门的数据库连接关闭方法 conn.close()
            try {
                if (ps != null){
                    ps.close();
                }
            } catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    /**
     * 收款方法
     * */
    public void in(Connection conn, String inUser, double money){
        try {
            // 这里是 +
            String inMoneySQL = "update account set money=money+? where name=?";
            Object[] params = {money, inUser};
            // 预处理
            ps = conn.prepareStatement(inMoneySQL);
            // 设置参数
            for (int i = 0;i < params.length;i++){
                ps.setObject(i+1,params[i]);
            }
            int result = ps.executeUpdate();
            System.out.println("影响了"+result+"行");
        } catch (Exception e){
            System.out.println("收款失败");
        } finally {
            // 释放资源，这里不释放conn，因为事务使用的是同一个数据库连接，
            // 在后面定义一个专门的数据库连接关闭方法 conn.close()
            try {
                if (ps != null){
                    ps.close();
                }
            } catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    /**
     * 回收资源方法
     * */
    /*public void close(){
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
