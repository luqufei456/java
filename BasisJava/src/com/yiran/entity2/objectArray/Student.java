package com.yiran.entity2.objectArray;

/**
 * 创建一个学生数组，存储三个学生对象并遍历
 *
 * 分析：
 * 		A:定义学生类
 * 		B:创建学生数组
 * 		C:创建学生对象
 * 		D:把学生对象作为元素赋值给学生数组
 * 		E:遍历学生数组
 * */

public class Student {
    private String name;
    private int age;

    public Student(){}

    public Student(String name){
        this.name = name;
    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void show(){
        System.out.println("the student name is "+name+" ,age is "+age+".");
    }

}
