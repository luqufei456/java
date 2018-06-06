package com.yiran3.entity2.jdbcDemo;

import org.junit.Test;

/**
 * JDBC API详解--注解驱动
 *
 *  获得驱动
 * 1. JDBC规范规定，如果需要连接数据库，必须提供驱动接口的实现类
 * 		驱动接口：java.sql.Driver
 * 		每一个数据库提供驱动jar 都实现该接口，可以自己看看实现类的源码
 * 2. MySQL 提供实现类：com.mysql.jdbc.Driver
 * 		源码：public class com.mysql.jdbc.Driver implements java.sql.Driver {
 * 3. JDBC规范提供了，注册实现方式
 * 		DriverManager.registerDriver( new com.mysql.jdbc.Driver() );
 * 		但，如果遵循上面语句，Java代码与 mysql实现类耦合(直接关系)，之后切换数据库将不能进行。
 * 		希望提供方案时，只要切换数据驱动，就可以切换使用数据库
 * 4. 通常注册驱动使用标准写法
 * 		Class.forName("com.mysql.jdbc.Driver")
 * 		1) 使用反射的方式加载指定的类
 * 		2) 具体加载的类以字符串(类的全限定名称)体现，内容就可以存放到配置文件中，通过修改配置文件方便切换数据库
 * 		3) 一个类被加载到内存，静态代码块将执行，static{ ... }
 * 		4) com.mysql.jdbc.Driver 源码分析
 * 			static{
 * 				java.sql.DriverManager.registerDriver(new Driver());
 */

public class JdbcAPIDemo1 {
    // 测试 注解驱动
    @Test
    public void test01() throws Exception{
        // 依上注解所言
        // 结论：注册驱动
        String jdbcPath = "com.mysql.jdbc.Driver";
        Class.forName(jdbcPath);
    }
}
