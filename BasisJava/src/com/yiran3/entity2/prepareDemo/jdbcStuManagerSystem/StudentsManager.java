package com.yiran3.entity2.prepareDemo.jdbcStuManagerSystem;

/**
 * 学生管理系统的管理方法类
 * */

import java.sql.*;

public class StudentsManager {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public StudentsManager(){
        // 注册驱动，连接数据库
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.13.22:3306/mydb",
                    "root","root");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 1、添加学生
    public void addStudent(JdbcStudent stu){
        try {
            // 处理sql语句
            String sql = "insert into students values (?,?,?,?)";
            // 获得预处理对象
            pst = conn.prepareStatement(sql);
            // 设置实际参数
            pst.setString(1, stu.getSno());
            pst.setString(2, stu.getSname());
            pst.setInt(3, stu.getAge());
            pst.setDouble(4, stu.getScore());
            // 接受返回值
            int i = pst.executeUpdate();
            System.out.println("影响了"+i+"行数据");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 关闭pst
            if (pst != null){
                try {
                    pst.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    // 2、显示所有学生
    public void showStudents(){
        try {
            // 处理sql语句
            String sql = "select * from students";
            // 获得预处理对象
            pst = conn.prepareStatement(sql);
            // 发送并接收返回值
            rs = pst.executeQuery();
            // 迭代取值
            while (rs.next()){
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                System.out.println(sno+", "+sname+", "+age+", "+score);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 释放资源
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
        }
    }

    ///3、根据学号查询学生信息
    public void snoShowStu(String sno){
        try {
            // 处理sql语句
            String sql = "select * from students where sno = ?";
            // 获得预处理对象
            pst = conn.prepareStatement(sql);
            // 设置实际参数
            pst.setString(1, sno);
            // 发送并接收返回值
            rs = pst.executeQuery();
            int len = 0;
            // 迭代取值
            while (rs.next()){
                len += 1;
                String sname = rs.getString("sname");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                System.out.println(sno+", "+sname+", "+age+", "+score);
            }
            if (len == 0){
                System.out.println("并没有该学号的学生");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 释放资源
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
        }
    }

    // 4、修改学生分数
    public void setScore(String sno, double score){
        try {
            // 处理sql语句
            String sql = "update students set score = ? where sno = ?";
            // 获得预处理对象
            pst = conn.prepareStatement(sql);
            // 设置实际参数
            pst.setDouble(1, score);
            pst.setString(2, sno);
            // 发送并接收返回值
            int i  = pst.executeUpdate();
            System.out.println("影响了"+i+"行数据");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 释放资源
            if (pst != null){
                try {
                    pst.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    // 5、根据学号删除学生
    public void delStu(String sno){
        try {
            // 处理sql语句
            String sql = "delete from students where sno = ?";
            // 获得预处理对象
            pst = conn.prepareStatement(sql);
            // 设置实际参数
            pst.setString(1, sno);
            // 发送并接收返回值
            int i  = pst.executeUpdate();
            System.out.println("影响了"+i+"行数据");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 释放资源
            if (pst != null){
                try {
                    pst.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    // 6、根据学号升序排序，分页显示学员信息，每页三条
    public void showPageStu(int pageSize, int pageNum){
        try {
            // 处理sql语句
            String sql = "select * from students order by sno asc limit ?,?";
            // 获得预处理对象
            pst = conn.prepareStatement(sql);
            // 设置实际参数
            pst.setInt(1, (pageNum-1)*pageSize);
            pst.setInt(2, pageSize);
            // 发送并接收返回值
            rs = pst.executeQuery();
            // 迭代取值
            while (rs.next()){
                System.out.println("当前是第"+pageNum+"页");
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                System.out.println(sno+", "+sname+", "+age+", "+score);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 释放资源
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
        }
    }

    // 关闭资源
    public void close(){
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
