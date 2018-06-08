package com.yiran3.entity2.dbUtilsDemo.queryDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import javax.sql.DataSource;

/**
 * ScalarHandler处理方式
 *     处理单值查询结果,执行的select语句后,结果集只有1个
 *     返回类型为数字，int还是long可以自己在new ScalarHandler<>()中定义
 * */

public class ScalarHandlerDemo {
    // ScalarHandler : 用于处理聚合函数执行结果(一行一列)
    // * 查询总记录数，用pid查也行，我用pid
    @Test
    public void scalarHandler(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);
            // 2.sql
            String sql = "select count(pid) from product";
            // 3.返回类型为数字，int还是long可以自己在new ScalarHandler<>()中定义
            long count = queryRunner.query(sql,new ScalarHandler<Long>());
            System.out.println("商品总数为："+count);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
