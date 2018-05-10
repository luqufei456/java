package com.yiran2.entity1.javaClass.inheritance.Demo3;

/**
 * 继承特点
 *
 * Java支持单继承
 * Java支持多层继承
 * */

public class ExtendsTest {
    public static void main(String[] args){
        // 创建子类对象
        SubClass yiran = new SubClass();
        // 通过 子类对象访问父类1 的成员属性
        yiran.name = "依然";
        System.out.println("我是子类：my name is "+yiran.name);
        // 通过子类访问父类1的 成员方法
        yiran.eat();
        // 通过子类访问父类2的成员方法 并不可以，因为没有继承，也无法继承， 父类2的成员属性同理
        // yiran.sleep();
        // 通过子类访问孙子类的成员方法 目前不可以，多态以后可以通过 父类 xx  = new 子类() 的形式来访问
        // yiran.isMe();

        // 创建孙子类对象
        GrandsonClass junnan = new GrandsonClass();
        // 通过孙子类访问父类的成员属性
        junnan.name = "陈君男";
        System.out.println("我是孙子类：my name is"+junnan.name);
        // 通过孙子类访问父类的成员方法
        junnan.eat();

    }
}
