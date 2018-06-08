package com.yiran3.entity2.dbUtilsDemo.queryDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.Map;

/**
 * MapHandler处理方式
 *     将数据表结果集的第一行数据,封装成Map集合
 *   键: 数据表中的列
 *   值: 这个列中的数据
 *
 *   处理方式的Map集合,是LinkedHashMap的子类,也就是说有序
 *
 *   主要用途：多表操作、将数据转换json 等
 * */

public class MapHandlerDemo {
    // MapHandler ： 将查询到的一条记录，封装到Map中，map.key=字段名，map.value=值
    // * 主要用途：多表操作、将数据转换json 等
    @Test
    public void mapHandler(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);
            // 2.sql语句
            String sql = "select * from product where pid=?";
            // 3.定义参数
            Object[] params = {10};
            // 4.接收map
            Map<String,Object> map = queryRunner.query(sql,new MapHandler(),params);
            // 输出map，也可以将map中的内容封装为JavaBean类
            System.out.println(map);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
