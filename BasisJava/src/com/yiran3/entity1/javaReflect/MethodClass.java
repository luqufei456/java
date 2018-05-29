package com.yiran3.entity1.javaReflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 获取成员方法并调用：
 *
 * 1.批量的：
 *      public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 *      public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 *      public Method getMethod(String name,Class<?>... parameterTypes):
 *                  参数：
 *                      name : 方法名；
 *                      Class ... : 形参的Class类型对象
 *      public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 *   调用方法：
 *      Method --> public Object invoke(Object obj,Object... args):
 *                  参数说明：
 *                  obj : 要调用方法的对象；
 *                  args:调用方式时所传递的实参；
 * */

public class MethodClass {

    // 定义一个静态方法用于返回Class对象
    public static Class getClassMethod() throws Exception{
        String className = "com.yiran3.entity1.javaReflect.StudentReflect1";
        return Class.forName(className);
    }

    @Test
    public void test01(){
        try {
            // 1.得到Class对象
            Class stuClass = getClassMethod();

            // 2.获取所有的公有方法
            System.out.println("-----获取所有的公有方法-----");
            Method[] methods = stuClass.getMethods();
            for (Method m : methods){
                System.out.println("公有方法："+m);
            }
            System.out.println();

            // 3.获取所有方法-包括私有
            System.out.println("-----获取所有方法-包括私有-----");
            methods = stuClass.getDeclaredMethods();
            for (Method m : methods){
                System.out.println("所有方法："+m);
            }
            System.out.println();

            // 4.获取公有的show1()方法
            System.out.println("----获取公有的show1()方法----");
            // 方法名  参数类型
            Method m = stuClass.getMethod("show1", String.class);
            System.out.println("show1()方法："+m);
            // 实例化一个对象，使用该方法
            Object obj = stuClass.getConstructor().newInstance();
            m.invoke(obj, "依然");
            System.out.println();

            // 5.获取私有的show4()方法
            System.out.println("----获取私有的show4()方法----");
            m = stuClass.getDeclaredMethod("show4", int.class);
            System.out.println("show4()方法："+m);
            m.setAccessible(true); // 解除私有绑定
            // 需要两个参数，一个是要调用的对象（获取有反射），一个是实参
            Object result = m.invoke(obj, 21);
            System.out.println("show4方法的返回值："+result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
