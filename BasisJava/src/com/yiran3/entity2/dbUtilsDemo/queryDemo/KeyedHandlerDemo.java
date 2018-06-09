package com.yiran3.entity2.dbUtilsDemo.queryDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.Map;

/**
 * KeyedHandler处理方式 ：
 *   new KeyedHandler("字段名称")，查询所有，将查询结果封装到Map中
 *      map.key=为指定“字段名称”对应的值
 *      map.value=为当前整条记录所有的值，数据为Map<字段名,值>
 *      类型  Map<String , Map<String,Object> >
 *
 *   不输入查询字段，则默认用第一个字段作为key值
 *   {1={pid=1, pname=华硕电脑, price=7000.0, cid=1}, ..}
 *
 *   这里使用pname当key值 例如：
 *   {神舟笔记本={pid=2, pname=神舟笔记本, price=5000.0, cid=1}, ..}
 *
 *   使用map集合时，查询中的排序是无效的，map自有一定规则
 * */

public class KeyedHandlerDemo {
    // 查询，将字段作为key-value键值对存储到map集合
    @Test
    public void KeyedHandler(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);
            // 2.sql语句
            String sql = "select * from product";
            // 3.接收map集合，指定字段名称为pname
            Map<String,Map<String,Object>> map = queryRunner.query(sql,new KeyedHandler<String>("pname"));
            System.out.println(map);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
