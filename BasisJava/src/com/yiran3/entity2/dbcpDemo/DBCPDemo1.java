package com.yiran3.entity2.dbcpDemo;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

/**
 * DBCP的基本配置
 * */

public class DBCPDemo1 {
    @Test
    public void test01(){
        // 1、获得连接池
        BasicDataSource dataSource = new BasicDataSource();
        // 1.1基本项
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.13.22:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        // 1.2其他项
        // 最大活动数
        dataSource.setMaxActive(10);
        // 初始化连接池中连接的个数
        dataSource.setInitialSize(5);
        // 最小空闲连接 空闲连接低于该值会创建新连接
        dataSource.setMinIdle(2);
        // 最大等待时间 默认为无限，设置为60000毫秒，
        // 防止因线程池不够用被无限挂起
        dataSource.setMaxWait(60000);
    }
}
