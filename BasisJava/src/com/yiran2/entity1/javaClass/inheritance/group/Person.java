package com.yiran2.entity1.javaClass.inheritance.group;

/**
 * Person类
 *
 * 姓名,年龄,宠物三个成员变量
 * 有showInfo(显示信息)的方法
 *
 * 当Pet作为Person的成员变量时,两个数据类型的关系为组合
 * */

public class Person {
    private String name;
    private int age;
    private Pet pet; // 这里定义的时候就不是什么 String 那些常用的 而是我们自己定义的宠物类

    public Person(){}

    public Person(String name, int age, Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
    }

    // showInfo() 显示个人信息方法
    public void showInfo(){
        System.out.println("我的名字叫"+this.name+",今年"+age+"岁");
        System.out.println("我的宠物是"+pet.getName()+"，它是"+pet.getKind()+"，是"+pet.getColor()+"色的");
    }

}
