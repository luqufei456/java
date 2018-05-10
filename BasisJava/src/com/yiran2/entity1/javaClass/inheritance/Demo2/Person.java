package com.yiran2.entity1.javaClass.inheritance.Demo2;

/**
 * 使用private修饰成员属性的父类
 * */

public class Person {
    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
