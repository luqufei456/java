package com.yiran3.entity2.dbUtilsDemo.queryDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

/**
 * ColumnListHandler处理方式
 *     将查询数据表结果集中的某一列数据,存储到List集合
 *     哪个列不清楚,数据类型也不清楚, List<Object>
 *  ColumnListHandler构造方法
 *    空参数: 获取就是数据表的第一列
 *    int参数: 传递列的顺序编号
 *    String参数: 传递列名
 *
 *  创建对象,可以加入泛型(String等),但是加入的数据类型,要和查询的列类型一致
 * */

public class ColumnListHandlerDemo {
    // ColumnListHandler ： 查询指定一列数据
    @Test
    public void columnListHandler(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);
            // 2.sql语句
            String sql = "select * from product";
            List<String> list = queryRunner.query(sql,new ColumnListHandler<String>("pname"));
            System.out.println(list);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
