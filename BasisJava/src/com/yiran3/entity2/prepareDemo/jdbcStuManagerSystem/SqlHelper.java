package com.yiran3.entity2.prepareDemo.jdbcStuManagerSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * sql工具类
 * query--查询
 * update--修改
 * close--关闭
 * */

public class SqlHelper {
    private Connection conn = null;

    public SqlHelper(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.13.22:3306/mydb",
                    "root","root");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public int update(String sql, Object[] params){
        int total = 0;
        PreparedStatement ps = null;
        try {
            // 预处理
            ps = conn.prepareStatement(sql);
            if (params != null && params.length!=0){
                for (int i = 0;i < params.length;i++){
                    // 不知道是什么类型  都用 setObject
                    ps.setObject(i+1, params[i]);
                }
            }
            total =  ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                ps.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return total;
    }

    public List query(String sql, Object[] params){
        List<Object[]> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd;
        try {
            // 初始化list
            list = new ArrayList<>();
            // 预处理
            ps = conn.prepareStatement(sql);
            if (params != null && params.length!=0){
                for (int i = 0;i < params.length;i++){
                    // 不知道是什么类型  都用 setObject
                    ps.setObject(i+1, params[i]);
                }
            }
            // 接收返回值
            rs = ps.executeQuery();
            // 得到元数据
            rsmd = rs.getMetaData();
            // 查询返回了几列数据 name id这样的
            // 决定了Object[] 的长度
            int count = rsmd.getColumnCount();
            while (rs.next()){
                Object[] objects = new Object[count];
                for (int i = 1;i <= count;i++){
                    objects[i-1] = rs.getObject(i);
                }
                list.add(objects);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps != null){
                try {
                    ps.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
        return list;
    }

    public void close(){
        try {
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
