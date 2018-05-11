package com.yiran2.entity1.javaClass.inheritance.memoryDemo;

/**
 * 父类
 *
 * 父类-人类:
 * 		属性：name，age
 * */

public class ThePerson {
    private String name;
    private int age;

    public ThePerson() {
        System.out.println("父类的哈希code为："+this.hashCode());
    }

    public ThePerson(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("父类的哈希code为："+this.hashCode());
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
}
