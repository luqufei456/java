package com.yiran2.entity1.javaGenerics.interType;

/**
 * 实现泛型接口的普通类，将类型定义为String
 *
 *  定义类时,就指定接口中的数据类型,定义一个不含泛型的正常类
 * */

public class MyClassInter1 implements MyInterType1<String> {
    @Override
    public void method(String str){
        System.out.println("这是一个将泛型接口实现为一个String类型的普通类:"+str);
    }

    public void intShow(int i){
        System.out.println("看来还是可以不用定义的类型，接收到的int："+i);
    }
}
