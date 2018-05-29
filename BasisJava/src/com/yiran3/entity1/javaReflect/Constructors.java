package com.yiran3.entity1.javaReflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 获取构造方法
 *
 * 1.获取构造方法：
 *    1).批量的方法：
 *       public Constructor[] getConstructors()：
 *          所有"公有的"构造方法
 *       public Constructor[] getDeclaredConstructors()：
 *          获取所有的构造方法(包括私有、受保护、默认、公有)
 *
 *    2).获取单个的方法，并调用：
 *       public Constructor getConstructor(Class... parameterTypes):
 *          获取单个的"公有的"构造方法：
 *       public Constructor getDeclaredConstructor(Class... parameterTypes):
 *          获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 *
 *    调用构造方法：
 *       Constructor-->newInstance(Object... initargs)
 *
 * 2、newInstance是 Constructor类的方法（管理构造函数的类）
 *    api的解释为：
 *       newInstance(Object... initargs)
 *       使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
 *       它的返回值是T类型，所以newInstance是创建了一个构造方法的声明类的新实例对象。并为之调用
 * */

public class Constructors {
    @Test
    public void test01(){
        // 1.创建实例
        StudentReflect1 stu1 = new StudentReflect1();
        System.out.println("stu1："+stu1);
        // 2.使用对象实例去调用成员方法
        stu1.setId(10);
        // 这里是因为重写了toString方法
        System.out.println("stu1"+stu1);
    }

    @Test
    public void test02(){
        try {
            // 1.使用forName创建Class对象
            String className = "com.yiran3.entity1.javaReflect.StudentReflect1";
            Class clazz = Class.forName(className);
            System.out.println("forName创建的class对象："+clazz);
            System.out.println();

            // 2.获取所有公有构造方法
            System.out.println("-------所有公有构造方法-------");
            Constructor[] conArray = clazz.getConstructors();
            for (Constructor c : conArray){
                System.out.println("构造方法："+c);
            }
            System.out.println();

            // 3.获取所有的构造方法
            System.out.println("所有的构造方法(包括：私有、受保护、默认、公有)");
            conArray = clazz.getDeclaredConstructors();
            for(Constructor c : conArray){
                System.out.println("构造方法："+c);
            }
            System.out.println();

            // 4.获取公有、无参的构造方法
            System.out.println("----获取公有、无参的构造方法----");
            Constructor con = clazz.getConstructor(null);
            // 1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
            // 2>、返回的是描述这个无参构造函数的类对象。
            System.out.println("公有、无参构造方法："+con);
            // 调用构造方法
            Object obj = con.newInstance();
            System.out.println();

            // 5.获取私有构造方法，和调用的过程
            System.out.println("******************获取私有构造方法，并调用*******************************");
            con = clazz.getDeclaredConstructor(int.class);
            System.out.println(con);
            //调用构造方法
            con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
            obj = con.newInstance(10);
            System.out.println("暴力访问得到的obj对象："+obj);
            System.out.println();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
