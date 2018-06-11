package com.yiran3.entity2.jdbcDemo.transaction;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * DbUtils事务操作
 *      conn.setAutoCommit(false)  开启事务
 *      new QueryRunner()  创建核心类，不设置数据源(手动管理连接)
 *
 *      query(conn , sql , handler, params )
 *      or  update(conn, sql , params)  手动传递连接
 *
 *      DbUtils.commitAndClose(conn)  提交并关闭连接
 *      DbUtils.rollbackAndClose(conn)  回滚并关闭连接
 * */

public class DbUtilsTransactionDemo1 {
    @Test
    public void test01(){
        // 使用DBUtils模板
        // 使用c3p0连接池创建出一个Connection对象
        DataSource dataSource = new ComboPooledDataSource("yiranApp");
        Connection conn = null;
        try {
            // 获得连接
            conn = dataSource.getConnection();
            // 1.开启事务
            conn.setAutoCommit(false);

            // ...

            // 提交并释放资源
            DbUtils.commitAndClose(conn);
        } catch (Exception e){
            try {
                DbUtils.rollbackAndClose(conn);
            } catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    @Test
    public void test02(){
        // 使用DBUtils模板
        // 使用c3p0连接池创建出一个Connection对象
        DataSource dataSource = new ComboPooledDataSource("yiranApp");
        Connection conn = null;
        /**
        * 这个地方，因为下面会传一个conn conn是通过完整的
        * 数据库连接而创建出来的。所以这个地方使用无参构造
        * 也可以使用下面的事务方法。同时，继续使用有参构造，
        * 因为是使用的相同连接配置，也不会出问题。为了便于理解
        * 最好还是使用无参构造，
        * 按方法重载来看的话，加了conn参数的方法，
        * 即使不管有参构造使用哪种配置，最后都是使用conn的配置，
        * 因为是对conn进行操作，而不是分配出一个新的conn1来进行操作
        * */
        QueryRunner queryRunner = new QueryRunner();
        try {
            // 获得连接
            conn = dataSource.getConnection();
            // 1.开启事务
            conn.setAutoCommit(false);

            // ...
            // sql 语句
            String sql = "update account set money=money+? where name=?";
            // @1 蠢觉给依然汇款，存款-1000
            int result1 = queryRunner.update(conn,sql, -1000,"chunjue");
            System.out.println("影响了"+result1+"行");

            // 模拟停电
            int i = 1/0;

            // @2 依然收到汇款，存款+1000
            int result2 = queryRunner.update(conn,sql, 1000,"yiran");
            System.out.println("影响了"+result2+"行");
            // 提交并释放资源
            DbUtils.commitAndClose(conn);
        } catch (Exception e){
            try {
                DbUtils.rollbackAndClose(conn);
            } catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
