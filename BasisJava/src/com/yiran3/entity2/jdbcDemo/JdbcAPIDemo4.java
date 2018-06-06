package com.yiran3.entity2.jdbcDemo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC API详解--结果集对象
 *
 * 获得语句执行者发送sql语句得到结果集
 * 移动游标
 * 		rs.next();  下一个
 * 		rs.previous(); 上一个
 * 获得指定列数据
 * 		rs.getXxx(String) ,通过字段名称获得内容
 * 		rs.getXxx(Integer) ,通过字段索引号获得内容
 *
 * 		例如 ：
 * 			rs.getString("cname")    获得指定名称
 * 			rs.getDouble(1)	获得第二列
 * */

public class JdbcAPIDemo4 {
    // 测试  结果集对象
    @Test
    public void test01() throws Exception{
        // 1.注册驱动
        String jdbcPath = "com.mysql.jdbc.Driver";
        Class.forName(jdbcPath);

        // 2.获得连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.13.22:3306/mydb",
                "root","root");

        // 3.获得语句执行者
        Statement st = conn.createStatement();

        // 4.发送查询语句
        ResultSet rs = st.executeQuery("select * from category");

        // 5.处理结果，迭代
        // previous 与next相反，是从后往前迭代的
        // 这里的迭代，并不是将里面的东西取出来，而是相当于指针指向下一个元素
        // 指针初始位于结果集头部，所以一开始就使用previous()迭代，无法得到结果
        System.out.println(rs.previous()); // false
        System.out.println(rs.next()); // true
        while (rs.next()){
            // 获得一行数据
            Integer cid = rs.getInt("cid");
            String cname = rs.getString("cname");
            System.out.println(cid + ", " + cname);
            rs.previous();
        }

        // 6.关闭连接
        rs.close();
        st.close();
        conn.close();
    }
}
