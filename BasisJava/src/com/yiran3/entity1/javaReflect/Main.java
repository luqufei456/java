package com.yiran3.entity1.javaReflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 反射main方法,不要与当前main搞混了，当然我这里用junit测试来写
 * */

public class Main {
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

            // 2.获取main方法
            // 第一个参数：方法名称，第二个参数：方法形参的类型
            Method methodMain =stuClass.getMethod("main",String[].class);

            // 3.调用main方法
            // 第一个参数，对象类型，因为方法是static静态的，所以为null可以，
            // 第二个参数是String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数
            // 这里拆的时候将  new String[]{"a","b","c"} 拆成3个对象。。。所以需要将它强转。
            methodMain.invoke(null, (Object) new String[]{"a","b","c"});
            // methodMain.invoke(null, new Object[]{new String[]{"a","b","c"}});//方式二
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
