package com.yiran2.entity1.javaClass.inheritance.Demo1;

/**
 * Person类
 *
 * 父类-人类:
 * 		成员属性：年龄,姓名
 * 		成员方法：吃饭,睡觉,摸了！
 * */

public class Person {
    String name;
    int age;

    public Person(){}

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("我  吃了");
    }

    public void sleep(){
        System.out.println("我  睡了");
    }

    public void touch(){
        System.out.println("我  摸了！！");
    }

}
