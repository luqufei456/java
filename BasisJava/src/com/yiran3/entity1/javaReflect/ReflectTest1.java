package com.yiran3.entity1.javaReflect;

import org.junit.Test;

/**
 * 反射-获取Class对象
 *
 *   1、获取Class对象的三种方式
 *      1.1 Object ——> getClass();
 *      1.2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 *      1.3 通过Class类的静态方法：forName（String  className）(常用)
 *
 *   其中1.1是因为Object类中的getClass方法、因为所有类都继承Object类。从而调用Object类来获取
 *
 * 1 通过类型获得
 *   语法：类名.class
 *   应用场景：确定类型 等
 *   Class clazz1 = Bean.class;
 * 2 通过实例对象获得
 *   语法：对象.getClass()
 *   应用场景：在方法内部通过参数获得类型 等
 *   Bean bean = new Bean();
 *   Class clazz2 = bean.getClass();
 * 3 通过字符串获得
 *   语法：Class.forName("全限定类名")
 *   应用场景：通过配置获得字符串 等
 *   Class clazz3 = Class.forName("com.igeek_00_Bean.Bean");
 * */

public class ReflectTest1 {
    @Test
    public void test01(){
        // 1.已知明确的类名，获取class对象
        Class thisClass = StudentReflect1.class;
        System.out.println("方法1："+thisClass);
    }

    @Test
    public void test02(){
        // 2.已知对象，获取class对象
        StudentReflect1 stuReflect = new StudentReflect1();
        Class thisClass = stuReflect.getClass();
        System.out.println("方法2："+thisClass);
    }

    @Test
    public void test03(){
        // 3.全限定类名（包名.类名）,获取Class对象  ----常用
        try {
            String className = "com.yiran3.entity1.javaReflect.StudentReflect1";
            Class thisClass = Class.forName(className);
            System.out.println("方法3："+thisClass);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test04(){
        try {
            // 第一种方法
            Class clazz1 = StudentReflect1.class;

            // 第二种方法
            StudentReflect1 stuReflect1 = new StudentReflect1();
            Class clazz2 = stuReflect1.getClass();

            // 第三种方法
            String className = "com.yiran3.entity1.javaReflect.StudentReflect1";
            Class clazz3 = Class.forName(className);

            // 判断 clazz1 clazz2 是否是同一个对象
            System.out.println("clazz1 == clazz2："+(clazz1 == clazz2));

            // 判断 clazz2 clazz3 是否是同一个对象
            System.out.println("clazz2 == clazz3："+(clazz2 == clazz3));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
