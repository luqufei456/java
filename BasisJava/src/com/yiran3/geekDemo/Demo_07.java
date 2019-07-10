package com.yiran3.geekDemo;

import java.lang.reflect.Method;

// v0
public class Demo_07 {

    public Demo_07(int a,double b){}

    public Demo_07(double b, int a){}

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.yiran3.geekDemo.Demo_07");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }
}
