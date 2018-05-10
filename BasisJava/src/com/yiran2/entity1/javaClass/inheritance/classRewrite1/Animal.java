package com.yiran2.entity1.javaClass.inheritance.classRewrite1;

/**
 * 父类Animal
 * */

public class Animal {
    String name = "鸽l";

    public void eat(){
        System.out.println("吃了!");
    }

    public void sleep(){
        System.out.println("睡了！");
    }

    public static void staticFunction(){
        System.out.println("说了多少次，这是父类的静态方法");
    }

}
