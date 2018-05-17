package com.yiran2.entity1.javaGenerics.classType;

import java.util.ArrayList;

/**
 * 泛型使用的测试类
 *
 * 泛型类:
 *  		在类中使用泛型
 *
 *  定义：类名后<变量>如：class A<E> {使用E完全类的定义}
 *  使用：创建对象时确定类型
 *
 *  一般定义泛型使用E,T,V,K
 *
 *  泛型方法：
 *  		定义：方法返回值前<变量>如：public <T> void method(){使用T}
 *  		使用：调用方法时确定类型
 * */

public class MyClassTypeDemo1 {
    public static void main(String[] args){
        // 测试使用自己定义的泛型类
        MyClassType1<String> mct = new MyClassType1<String>();
        // 调用了使用类泛型的方法
        mct.setMyField("依然的第一个java泛型类");
        String str = mct.getMyField();
        System.out.println("在String泛型对象中写入的值为："+str);

        // 创建对象时指定泛型为Integer 则所有使用了泛型的方法根据对象类型一起改变
        MyClassType1<Integer> mct2 = new MyClassType1<Integer>();
        mct2.setMyField(1976967579);
        Integer QQ = mct2.getMyField();
        System.out.println("我的qq号为："+QQ);

        // 调用该类的泛型方法，在输入参数时确定类型
        // 定义三种类型，字符串 Integer 集合，查看是否都能当做泛型方法的参数
        String se = "这是一个字符串类型";
        Integer integer = 233;
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        integerArrayList.add(10);
        integerArrayList.add(20);
        integerArrayList.add(30);

        // 调用方法，最后发现能够输出，说明这几种类型，该泛型方法都能接收
        mct.methods(se);
        mct.methods(integer);
        mct.methods(integerArrayList);
    }
}
