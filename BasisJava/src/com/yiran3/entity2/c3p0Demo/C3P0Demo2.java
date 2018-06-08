package com.yiran3.entity2.c3p0Demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * TODO(使用c3p0-config.xml进行c3p0的配置)
 * c3p0-config.xml位于项目根目录 src目录下
 *
 * 1 获得连接池(数据源)
 * c3p0 jar包将自动加载“c3p0-config.xml”文件，并获得具体的配置信息
 * 在配置文件中 <named-config name="名称"> ，可以通过核心类 new ComboPooledDataSource("名称")
 * <default-config>默认的配置，通过 new ComboPooledDataSource() 直接使用
 * */

public class C3P0Demo2 {

    // 使用默认配置
    @Test
    public void test01(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            Connection conn = dataSource.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // 使用命名配置
    @Test
    public void test02(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource("yiranApp");
        try {
            Connection conn = dataSource.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
