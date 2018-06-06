package com.yiran3.entity2.jdbcDemo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC入门案例
 *
 *   了解jdbc开发步骤
 * */

public class JdbcDemo1 {
    @Test
    public void Test01() throws Exception{
        // 查询所有的分类信息
        // 注意：使用JDBC规范，采用都是 java.sql包下的内容

        // 1.注册驱动
        String jdbcPath = "com.mysql.jdbc.Driver";
        Class.forName(jdbcPath);

        // 2.获得连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.13.22:3306/mydb",
                "root", "root");

        // 3.获得语句执行者
        Statement st = conn.createStatement();

        // 4.执行sql语句
        ResultSet rs = st.executeQuery("select * from category");

        // 5.处理结果,返回的rs可以进行迭代
        while (rs.next()){
            // 获得一行数据
            Integer cid = rs.getInt("cid");
            String cname = rs.getString("cname");
            System.out.println(cid + ", " + cname);
        }

        // 6.释放资源，后开先关
        rs.close();
        st.close();
        conn.close();
    }
}