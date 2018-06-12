package com.yiran3.entity2.dbUtilsDemo.queryDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import javax.sql.DataSource;

/**
 * ScalarHandler处理方式
 *     处理单值查询结果,执行的select语句后,结果集只有1个
 *     返回类型由sql语句的返回值来定义，数字类的默认为long类型
 *     也可以返回String等类型。返回的并不是Object类型。
 *     但是可以用Object类型接收，这样不用挨个判断返回的是什么类型
 *
 *     ScalarHandler 的参数为空或null时，返回第一行第一列的数据
 *     ScalarHandler 的参数可以是列的索引（从1开始）或列名
 * */

public class ScalarHandlerDemo {
    // ScalarHandler : 用于处理聚合函数执行结果(一行一列)
    // * 查询总记录数，用pid查也行，我用pid
    @Test
    public void scalarHandler(){
        try {
            // 获得dataSource
            DataSource dataSource =
                    new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner =
                    new QueryRunner(dataSource);
            // 2.sql
            String sql = "select count(pid) from product";
            // ScalarHandler 的参数为空或null时，返回第一行第一列的数据
            // String sql = "select * from product";

            // 可以接收不同类型 String  long 等
            // String sql = "select pname from product where pid=1";

            // 可以使用 new ScalarHandler<>("字段名" or 索引) 来过滤 pname or 2
            // String sql = "select * from product where pid=1";

            // 3.返回类型不定，由查询语句决定，可用Object接收
            // 也可以通过 new ScalarHandler<>("字段名" or 索引) 来过滤
            Object count = queryRunner.query(sql,new ScalarHandler<>());
            System.out.println("商品总数为："+count);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
