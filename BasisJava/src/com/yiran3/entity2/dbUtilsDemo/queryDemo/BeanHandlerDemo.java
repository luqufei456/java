package com.yiran3.entity2.dbUtilsDemo.queryDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import javax.sql.DataSource;

/**
 * 查询数据表结果集处理其中一种方式:
 *   BeanHandler处理方式
 *     将数据表的结果集第一行数据,封装成JavaBean类的对象
 *   构造方法:
 *     BeanHandler(Class<T> type)
 *     传递一个Class类型对象,将结果封装到哪个类的对象呢
 *     Product类的Class对象
 */

public class BeanHandlerDemo {
    // 通过id查询详情，将查询结果封装到JavaBean product
    @Test
    public void beanHandlerTest01(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);
            // 2.sql语句
            String sql = "select * from product where pid=?";
            // 3.实际参数
            Object[] params = {10};
            // 4.查询并封装
            Product product = queryRunner.query(sql,new BeanHandler<>(Product.class),params);
            // 重写toString方法并输出
            System.out.println(product);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
