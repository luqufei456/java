package com.yiran3.entity2.jdbcDemo.transaction;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * jdbc的事务操作
 *      conn.setAutoCommit(false)  开启事务
 *      conn.commit()  提交事务
 *      conn.rollback()  回滚事务
 * */

public class JdbcTransactionDemo1 {
    // 方法示例
    @Test
    public void test01(){
        // 使用c3p0连接池创建出一个Connection对象
        DataSource dataSource = new ComboPooledDataSource("yiranApp");
        Connection conn = null;
        try {
            // 1.获得连接
            conn = dataSource.getConnection();

            // 2.开启事务
            conn.setAutoCommit(false);

            // ... 内容

            // 3.提交事务
            conn.commit();
        } catch (Exception e){
            // 第一次写try嵌套~
            try {
                // 4.回滚事务
                if (conn != null)
                    conn.rollback();
            } catch (Exception e1){
                e1.printStackTrace();
            }
        } finally {
            try {
                // 5.释放资源
                if (conn != null)
                    conn.close();
            } catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    @Test
    public void test02(){
        // 使用c3p0连接池创建出一个Connection对象
        DataSource dataSource = new ComboPooledDataSource("yiranApp");
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.获得连接
            conn = dataSource.getConnection();

            // 2.开启事务
            conn.setAutoCommit(false);

            // ... 内容
            String sql = "update account set money=money+? where name=?";
            // 预处理
            ps = conn.prepareStatement(sql);

            // 蠢觉给依然汇款
            ps.setObject(1,-1000);
            ps.setObject(2,"chunjue");
            int result1 = ps.executeUpdate();
            System.out.println("影响了"+result1+"行");

            // 模拟停电 -- 这个地方会报错，导致回滚
            int i = 1/0;

            // 依然收款
            ps.setObject(1,1000);
            ps.setObject(2,"yiran");
            int result2 = ps.executeUpdate();
            System.out.println("影响了"+result2+"行");

            // 3.提交事务
            conn.commit();
        } catch (Exception e){
            // 第一次写try嵌套~
            try {
                // 4.回滚事务
                if (conn != null)
                    conn.rollback();
            } catch (Exception e1){
                e1.printStackTrace();
            }
        } finally {
            try {
                // 5.释放资源
                if (conn != null)
                    conn.close();
            } catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
