package com.yiran2.entity1.javaClass.polymorphism.test1;

/**
 * 用于展示多态的子类
 *
 * 在父类的共性功能之外,有自己的学习工作方法
 * */

public class Person extends Animal {
    @Override
    public void eat() {
        System.out.println("我  君男 吃爆");
    }

    @Override
    public void sleep() {
        System.out.println("我  君男 睡爆");
    }

    public void study(){
        System.out.println("我  君男 不学");
    }

    public void work(){
        System.out.println("我  君男 摸鱼");
    }
}
