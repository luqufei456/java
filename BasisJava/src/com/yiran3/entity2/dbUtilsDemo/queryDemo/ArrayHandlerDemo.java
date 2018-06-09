package com.yiran3.entity2.dbUtilsDemo.queryDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * ArrayHandler处理方式
 *    将数据表中的第一行数据,存储到对象数组Object[]中
 *
 *  注意: 获取查询后的第一行数据,如果查询不到结果集,返回的对象数组的length=0
 * */

public class ArrayHandlerDemo {
    // ArrayHandler ：查询一条记录，将数据封装到数组中
    @Test
    public void arrayHandler(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);
            // 2.sql语句
            String sql = "select * from product where pid=?";
            // 3.实际参数
            Object[] params = {10};
            // 4.接收数组
            Object[] arr = queryRunner.query(sql,new ArrayHandler(),params);
            // 判断接收到查询集了，输出
            if (arr.length != 0){
                System.out.println(Arrays.toString(arr));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
