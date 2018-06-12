package com.yiran3.entity2.transactionTest1.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * jdbc工具类
 *
 *      在“事务传递参数版”中，我们必须修改方法的参数个数，传递链接，
 * 才可以完成整个事务操作。如果不传递参数，是否可以完成？
 * 在JDK中给我们提供了一个工具类：ThreadLocal，此类可以在一个线程中共享数据。
 *
 *      java.lang.ThreadLocal 该类提供了线程局部 (thread-local) 变量，
 * 用于在当前线程中共享数据。ThreadLocal工具类底层就是一个Map，
 * key存放的当前线程，value存放需要共享的数据。不同的线程一般无法访问别的线程存储的共享数据。
 * 因为共享数据是 一个线程中共享
 *
 * 这个工具类中，相当于同一个线程，共享一个Connection数据库连接，不同的线程，使用的数据库连接不同
 *
 * 在这个例子中使用，可以保证所有操作都使用的同一个数据库连接，这样一旦开始事务，
 * 则不会被多个同时操作导致数据混乱，不过我自己定义的就是使用的同一个数据库连接，所以这个工具类没什么用。
 * */

public class YiRanJdbcUtils {
    // 连接池
    private static DataSource dataSource = new ComboPooledDataSource("yiranApp");
    // 给当前线程绑定连接
    private static ThreadLocal<Connection> local = new ThreadLocal<>();

    public static Connection getConnection(){
        try {
            // 1.从当前线程中，获得已经绑定的连接
            Connection conn = local.get();
            if (conn == null){
                // 2.第一次获得时，绑定内容从连接池获得
                conn = dataSource.getConnection();
                // 3.将连接存入ThreadLocal
                local.set(conn);
            }
            // 获得连接
            return conn;
        } catch (Exception e){
            // 将编译时异常 转换 运行时 ， 以后开发中 运行时异常使用比较多的。
            // * 此处可以编写自定义异常。
            throw new RuntimeException(e);
            // * 类与类之间 进行数据交换时，可以使用return返回值。
            // 也可以自定义异常返回值，调用者try{} catch(e){
            // e.getMessage() 获得需要的数据}
            // throw new MyConnectionException(e);
        }
    }
}
