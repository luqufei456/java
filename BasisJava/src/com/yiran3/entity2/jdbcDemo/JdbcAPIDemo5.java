package com.yiran3.entity2.jdbcDemo;

import org.junit.Test;

import java.sql.*;

/**
 * JDBC API详解--释放资源
 * */

public class JdbcAPIDemo5 {
    // 测试  释放资源
    @Test
    public void test01(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 1.注册驱动
            String jdbcPath = "com.mysql.jdbc.Driver";
            Class.forName(jdbcPath);

            // 2.获得连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.13.22:3306/mydb",
                    "root", "root");

            // 3.获得语句执行者
            st = conn.createStatement();

            // 4.执行sql语句
            rs = st.executeQuery("select * from category");
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            // 这里是并列，所以不能用else if
            // 如果用else那conn要先关，不行
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
