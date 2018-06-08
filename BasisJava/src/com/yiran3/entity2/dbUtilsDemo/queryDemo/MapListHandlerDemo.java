package com.yiran3.entity2.dbUtilsDemo.queryDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * MapListHandler处理方式
 *     将数据表的结果集的每一行封装成Map集合
 *     数据表多行数据,出现多个Map集合,存储List集合
 *
 *     主要用途：多表操作 等
 * */

public class MapListHandlerDemo {
    // MapListHandler ： 查询所有数据，将每一条记录封装到Map中，然后将Map添加到List中，最后返回List
    // * 主要用途：多表操作 等
    @Test
    public void mapListHandler(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);
            // 2.sql语句
            String sql = "select * from product";
            // 3.接收map
            List<Map<String,Object>> mapList = queryRunner.query(sql,new MapListHandler());
            // 4.遍历
            for (Map map : mapList){
                System.out.println(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
