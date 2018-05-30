package com.yiran3.entity1.properties.testDemo1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * 测试类
 *    目的：封装两个Properties文件中的内容
 * */

public class ConfigTest01 {
    // 定义两个静态String存储路径
    private static String path1 = "staticFile\\PropertiesTest\\className.properties";
    private static String path2 = "staticFile\\PropertiesTest\\data.properties";

    // 从配置文件className.properties中读取应该要创建的是哪一个类
    @Test
    public void test01(){
        try {
            // 1.从className.properties中获取类名
            Properties props = new Properties();
            // 使用转换流
            FileInputStream fis = new FileInputStream(path1);
            Reader reader = new InputStreamReader(fis,"utf-8");
            props.load(reader);
            String className = props.getProperty("classname");
            System.out.println("className："+className);

            // 2.创建该类的class实例 -- 不是对象实例
            Class clazz = Class.forName(className);

            // 3.找到该类的有参构造方法
            Constructor con = clazz.getConstructor(int.class, String.class);

            // 4.利用构造器填入数，创建对象实例
            Object obj = con.newInstance(20,"蠢觉");
            // 直接输出对象实例会自动调用toString()
            System.out.println(obj);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 从配置文件data.properties中读取数据并填入实例
    @Test
    public void test02(){
        try {
            // 1.获取学生类的Class实例
            Class clazz = ProStudent.class;

            // 2.获取学生类的有参构造方法
            Constructor con = clazz.getConstructor(int.class, String.class);

            // 3.从data.properties中读取数据
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(path2);
            // 这里使用gbk  因为记事本写进去的时候默认编码为gbk
            Reader reader = new InputStreamReader(fis,"gbk");
            props.load(reader);

            // 获取id与name的值
            String sId = props.getProperty("id");
            String name = props.getProperty("name");
            // 将String转为Integer 再转为int, 自动拆箱
            // 一般用 Integer.parseInt()
            int id = Integer.valueOf(sId);

            // 4.通过得到的构造方法创建对象实例
            Object obj = con.newInstance(id, name);
            // 输出
            System.out.println(obj);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
