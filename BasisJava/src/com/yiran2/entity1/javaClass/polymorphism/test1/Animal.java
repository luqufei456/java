package com.yiran2.entity1.javaClass.polymorphism.test1;

/**
 *  用于展示多态的抽象父类
 *
 * 	吃饭,睡觉功能
 * */

public abstract class Animal {
    public void eat(){
        System.out.println("动物吃了");
    }

    // 抽象方法
    public abstract void sleep();
}
