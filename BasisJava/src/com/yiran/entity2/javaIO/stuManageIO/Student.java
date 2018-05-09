package com.yiran.entity2.javaIO.stuManageIO;

/**
 * 学生管理系统--学生类
 *  学号 long
 *  姓名 String
 *  年龄 int
 *  性别 String
 *  地址 String
 * */

public class Student {
    private String id;
    private String name;
    private String age;
    private String gender;
    private String address;

    // 构造方法列
    public Student(){}

    public Student(String id, String name, String age, String gender, String address){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    // get方法列
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }


    // set方法列
    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(String age){
        this.age = age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setAddress(String address){
        this.address = address;
    }

    // 重写toString()方法
    public String toString(){
        return this.getId()+","+this.getName()+","+this.getGender()+","+this.getAge()+","+this.getAddress();
    }

}