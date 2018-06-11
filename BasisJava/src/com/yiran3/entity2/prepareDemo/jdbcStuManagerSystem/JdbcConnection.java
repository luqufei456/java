package com.yiran3.entity2.prepareDemo.jdbcStuManagerSystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 如果有多个管理系统，例如 教师管理系统，学生管理系统
 *
 * 想使多个管理系统同时使用一个数据库连接，不考虑并发
 *
 * 则使内存中同时只存在一个数据库连接
 *
 * 使该类不能有子类，不能创建对象
 *
 * 创建一个静态的Connection
 * */

public final class JdbcConnection {
    private static Connection conn = null;

    // 私有构造方法，这样就不能得到对象了
    private JdbcConnection(){}

    public static Connection getConn(){
        if (conn != null){
            return conn;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.13.22:3306/mydb",
                    "root","root");
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void connClose(){
        try {
          conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
