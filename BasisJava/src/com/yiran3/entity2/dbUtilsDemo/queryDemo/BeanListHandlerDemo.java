package com.yiran3.entity2.dbUtilsDemo.queryDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.List;

/**
 * BeanListHandler处理方式
 *     将数据表的每一行数据,封装成JavaBean类对象
 *     多行数据了,多个JavaBean对象,存储List集合
 * */

public class BeanListHandlerDemo {
    //查询所有，将每一条记录封装到一个JavaBean，
    // 然后将JavaBean添加到List中，最后返回List
    @Test
    public void beanListHandler(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);
            // 2.sql语句
            String sql = "select * from product";
            // 3.可以传参也可以不传参，虽然这里不需要，但是我们传一下试试
            Object[] params = {};
            List<Product> list = queryRunner.query(sql,new BeanListHandler<>(Product.class),params);
            for (Product product : list){
                System.out.println(product);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
