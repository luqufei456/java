package com.yiran3.entity2.c3p0Demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * TODO(C3P0的基本配置)
 * */

public class C3P0Demo1 {
    @Test
    public void test01(){
        try {
            // 1.获得连接池(数据源)
            ComboPooledDataSource dataSource = new ComboPooledDataSource();

            // 1.1设置基本项
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://192.168.13.22:3306/mydb");
            dataSource.setUser("root");
            dataSource.setPassword("root");

            // 1.2设置其他项
            // 初始化连接池中连接的个数 default 3
            dataSource.setInitialPoolSize(5);
            // 最大/最小 连接池中连接的个数  max default 15
            dataSource.setMaxPoolSize(10);
            dataSource.setMinPoolSize(2);
            // 最大空闲时间，超过时间会断开连接；
            // default 0，永远不断开
            dataSource.setMaxIdleTime(60);
            // 无可用连接时每次新建连接数
            // default 3
            dataSource.setAcquireIncrement(2);

            // 2.获得连接
            Connection conn = dataSource.getConnection();
            System.out.println(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
