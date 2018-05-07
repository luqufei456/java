package com.yiran.entity2.stuManage;

/**
 * 学生管理系统--学生类
 *  学号 long
 *  姓名 String
 *  年龄 int
 *  性别 String
 *  地址 String
 * */

public class Student {
    private long id;
    private String name;
    private int age;
    private String gender;
    private String address;

    // 构造方法列
    public Student(){}

    public Student(long id, String name, int age, String gender, String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    // get方法列
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }


    // set方法列
    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setAddress(String address){
        this.address = address;
    }

}
