package com.yiran3.entity2.jdbcDemo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC API详解--获得语句执行者
 *
 * 获得语句执行者
 * 	通过Connection就可以获得针对不同数据库sql语句的执行对象，常用  createStatement()
 * 	通过Statement对象可以执行任意的SQL语句
 * 		st.executeUpdate(sql)
 * 	    	执行语句(增删改 insert、delete、update) ，返回为整形，表示影响行数。
 *
 * 		st.executeQuery(sql)
 * 	    	执行DQL语句(查询 select) ，返回ResultSet结果集对象(查询所有数据)
 *
 * 		st.execute(sql)  了解，可以执行任意sql语句。返回为boolean
 * 			true，表示执行DQL语句，需要通过ts.getResultSet() 获得查询结果。
 * 			false，表示DML语句，需要通过 ts.getUpdateCount() 获得影响行数。
 * */

public class JdbcAPIDemo3 {
    // 测试  获得语句执行者
    @Test
    public void test01() throws Exception{
        // 1.注册驱动
        String jdbcPath = "com.mysql.jdbc.Driver";
        Class.forName(jdbcPath);

        // 2.获得连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.13.22:3306/mysql",
                "root","root");

        // 3.结论：获得语句执行者
        // 实际上是不能发出null 或者空字符串查询，会报错
        Statement st = conn.createStatement();
        boolean execute = st.execute(null);
        int executeUpdata = st.executeUpdate("");
        ResultSet rs = st.executeQuery("");
    }
}
