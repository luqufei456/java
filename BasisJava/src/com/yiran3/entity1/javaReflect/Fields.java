package com.yiran3.entity1.javaReflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 *  获取成员变量并调用：
 *
 * 1.批量的
 *      1).Field[] getFields():获取所有的"公有字段"
 *      2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 *      1).public Field getField(String fieldName):获取某个"公有的"字段；
 *      2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 *   设置字段的值：
 *      Field --> public void set(Object obj,Object value):
 *                  参数说明：
 *                  1.obj:要设置的字段所在的对象；
 *                  2.value:要为字段设置的值；
 * */

public class Fields {

    // 定义一个静态方法用于返回Class对象
    public static Class getClassMethod() throws Exception{
        String className = "com.yiran3.entity1.javaReflect.StudentReflect1";
        return Class.forName(className);
    }

    @Test
    public void test01(){
        try {
            // 1.获取Class对象
            Class stuClass = getClassMethod();

            // 2.获取所有公有的字段
            System.out.println("-----获取所有公有的字段-----");
            Field[] fields = stuClass.getFields();
            for (Field f : fields){
                System.out.println("公有字段："+f);
            }
            System.out.println();

            // 3.获取所有字段-包括私有
            System.out.println("-----获取所有字段-包括私有-----");
            fields = stuClass.getDeclaredFields();
            for (Field f : fields){
                System.out.println("所有字段："+f);
            }
            System.out.println();

            // 4.获取公有字段id并调用
            System.out.println("-----获取公有字段id并调用-----");
            Field f = stuClass.getField("id");
            System.out.println("公有字段id："+f);
            // 获取一个实例对象
            Object obj = stuClass.getConstructor().newInstance();
            // 为字段设置值
            f.set(obj, 20);
            // 验证学号
            StudentReflect1 stu = (StudentReflect1)obj;
            System.out.println("验证学号："+stu.id);
            System.out.println();

            // 5.获取私有字段name并调用
            System.out.println("-----获取私有字段name并调用-----");
            f = stuClass.getDeclaredField("name");
            System.out.println("私有字段name："+f);
            f.setAccessible(true); // 暴力反射，解除私有绑定
            f.set(obj, "依然");
            System.out.println("验证："+stu);
            System.out.println("f.get(obj)："+f.get(obj));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
