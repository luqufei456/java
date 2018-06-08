package com.yiran3.entity2.prepareDemo;

import org.junit.Test;

import java.sql.*;

/**
 * JDBC 预处理对象--增删改查
 * */

public class PrepareDemo2 {
    // 增,向分类表中添加数据
    @Test
    public void test01(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // 1.获得连接
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.13.22:3306/mydb",
                    "root", "root");
            // 2.处理sql语句
            String sql = "insert into category(cname) values(?)";
            // 3.获得预处理对象
            pst = conn.prepareStatement(sql);
            // 4.设置实际参数
            pst.setString(1,"电子用品");
            // 5.执行，接收返回结果
            int r = pst.executeUpdate();
            System.out.println("影响了"+r+"行");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 6.释放资源
            if (pst != null){
                try {
                    pst.close();
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

    @Test
    // 修改操作
    public void test02(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // 1.获得连接
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.13.22:3306/mydb",
                    "root", "root");
            // 2.处理sql语句
            String sql = "update category set cname = ? where cid = ?";
            // 3.获得预处理对象
            pst = conn.prepareStatement(sql);
            // 4.设置实际参数
            pst.setString(1,"汽车");
            pst.setInt(2,4);
            // 5.执行，接收返回结果
            int r = pst.executeUpdate();
            System.out.println("影响了"+r+"行");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 6.释放资源
            if (pst != null){
                try {
                    pst.close();
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

    // 删除操作
    @Test
    public void test03(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // 1.获得连接
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.13.22:3306/mydb",
                    "root", "root");
            // 2.处理sql语句
            String sql = "delete from category where cid = ?";
            // 3.获得预处理对象
            pst = conn.prepareStatement(sql);
            // 4.设置实际参数
            pst.setInt(1, 4);
            // 5.执行，接收返回结果
            int r = pst.executeUpdate();
            System.out.println("影响了"+r+"行");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 6.释放资源
            if (pst != null){
                try {
                    pst.close();
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

    // 查询所有数据
    @Test
    public void test04(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // 1.获得连接
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.13.22:3306/mydb",
                    "root", "root");
            // 2.处理sql语句
            String sql = "select * from category";
            // 3.获得预处理对象
            pst = conn.prepareStatement(sql);
            // 4.执行，接收返回结果
            rs = pst.executeQuery();

            // 获得结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获得第一列的列名
            String columnName = rsmd.getColumnName(1);
            // 获得列总数
            int count = rsmd.getColumnCount();
            // 获取第一列类型号
            int type = rsmd.getColumnType(1);
            // 获取第一列类型名
            String type1 = rsmd.getColumnTypeName(1);
            // 5.迭代接收结果
            while (rs.next()){
                Integer cid = rs.getInt("cid");
                String cname = rs.getString("cname");
                System.out.println(cid+", "+cname);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 6.释放资源
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (pst != null){
                try {
                    pst.close();
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
