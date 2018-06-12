package com.yiran3.entity2.dbcpDemo;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.util.Properties;

/**
 * 使用配置文件配置dbcp
 * */

public class DBCPDemo2 {
    @Test
    public void test01(){
        // 1.获得连接池
        // 1.1 加载properties文件，获得properties对象
        /** 第一种方法 */
        // 通过类名获得Class对象
        Class clazz = DBCPDemo2.class;
        // 获得类加载器对象
        ClassLoader classLoader = clazz.getClassLoader();
        // 获得资源输入流 这里的路径是相对于src下 而不是项目根目录下
        InputStream is = classLoader.getResourceAsStream("dbcp-config.properties");

        try {
            /** 第二种方法 */
            // 正常方法获得输入流
            String path = "src\\dbcp-config.properties";
            FileInputStream fis = new FileInputStream(path);
            Reader reader = new InputStreamReader(fis, "utf-8");
            // 通过properties加载对象流
            Properties props = new Properties();
            /** 这里不管是is fis 还是reader 都可以 */
            props.load(is);

            // 1.2 获得连接池
            // BasicDataSourceFactory.createDataSource()
            // 通过得到properties的配置来创建一个连接池
            DataSource dataSource = BasicDataSourceFactory.createDataSource(props);

            // 2.获得连接
            Connection conn = dataSource.getConnection();
            System.out.println(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
