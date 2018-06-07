package com.yiran3.entity2.prepareDemo;

import org.junit.Test;

import java.sql.*;

/**
 * JDBC 预处理对象--SQL注入问题
 * */

public class PrepareDemo1 {
    // 模拟用户登录
    @Test
    public void test01(){
        // 模拟用户登录
        String username = "root";
        String password = "root";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.13.22:3306/yiran_java",
                    "root", "root");
            st = conn.createStatement();
            rs = st.executeQuery("select * from users where username='"
                    +username+"' and password='"+password+"'");
            if (rs.next()){
                System.out.println("登陆成功");
            }
            else{
                System.out.println("登录失败");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
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
