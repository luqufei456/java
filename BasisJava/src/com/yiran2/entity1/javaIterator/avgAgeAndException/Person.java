package com.yiran2.entity1.javaIterator.avgAgeAndException;

/**
 * Person人类
 *
 *   A：定义一个Person类,
 *		里面有姓名和年龄属性,生成对应的getter/setter方法,
 *		以及满参构造,空参构造
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

    public void show(){
        System.out.println(this.name+"的年龄为"+this.age);
    }
}
