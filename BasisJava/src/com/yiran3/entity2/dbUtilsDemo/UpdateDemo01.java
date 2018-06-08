package com.yiran3.entity2.dbUtilsDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import javax.sql.DataSource;

/**
 * 构造方法
 * QueryRunner() 创建核心类，没有提供数据源，在进行具体操作时，需要手动提供Connection
 *              ---需要dataSource
 *
 * 普通方法
 * update(Connection conn , String sql , Object ... params)
 *          使用提供的Connection，完成修改语句
 * query(Connection conn , String sql , ResultSetHandler , Object ... params)
 *          使用提供的Connection，执行查询语句，并将查询结果封装到对象中。
 * */

public class UpdateDemo01 {
    // 添加
    @Test
    public void insert(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);

            // 2.执行update方法
            String sql = "insert into product" + " (pname,price,cid) values (?,?,?)";
            Object[] params = {"外星人", 30000, 1};
            int i = queryRunner.update(sql, params);
            System.out.println("影响了"+i+"行数据");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 修改
    @Test
    public void update(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);

            // 2.执行update方法
            String sql = "update product set " + "pname=?,price=?,cid=? where pid=?";
            Object[] params = {"外星人", 29999, 1,10};
            int i = queryRunner.update(sql, params);
            System.out.println("影响了"+i+"行数据");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 删除
    @Test
    public void delete(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);

            // 2.执行update方法
            String sql = "delete from product where pid=?";
            Object[] params = {11};
            int i = queryRunner.update(sql, params);
            System.out.println("影响了"+i+"行数据");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
