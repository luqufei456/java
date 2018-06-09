package com.yiran3.entity2.dbUtilsDemo.queryDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayListHandler处理方式
 *  将数据表中的每一行数据,存储到一个对象数组Object[]中
 *  而数据表中会有多行数据,产生多个对象数组, 存储到List集合中
 * */

public class ArrayListHandlerDemo {
    // ArrayListHandler ：查询所有，
    // 将每一条记录封装到数组中，然后添加到List，最后返回list
    @Test
    public void arrayListHandler(){
        try {
            // 获得dataSource
            DataSource dataSource = new ComboPooledDataSource("yiranApp");
            // 1.核心类
            QueryRunner queryRunner = new QueryRunner(dataSource);
            // 2.sql语句
            String sql = "select * from product";
            // 3.接收存储数组的集合
            List<Object[]> list = queryRunner.query(sql,new ArrayListHandler());
            // 遍历 用一下迭代器
            Iterator<Object[]> iter = list.iterator();
            while (iter.hasNext()){
                Object[] arr = iter.next();
                System.out.println(Arrays.toString(arr));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
