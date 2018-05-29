package com.yiran3.entity1.javaReflect;

/**
 * 反射的数据准备
 *    提供JavaBean，用于之后反射操作 JavaBean规范
 *      1.提供私有字段，例如：private String id;
 *      2.必须提供getter或setter方法 （可以使用快捷键生产，alt+shift+s）
 *      3.提供无参构造方法
 * */

public class StudentReflect1 {
    // 字段 field
    public int id;
    private String name;

    // 构造器 Constructor
    public StudentReflect1(int id, String name){
        this.id = id;
        this.name = name;
    }

    public StudentReflect1(){}

    private StudentReflect1(int id){
        this.id = id;
    }

    // 方法 Method

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 静态方法
    public static int getCount(int c){
        return c*100;
    }

    // 重写toString方法
    @Override
    public String toString(){
        return "Student [id：" + id + ", name：" + name + "]";
    }

    // 成员方法
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }

    // Student的main方法
    public static void main(String[] args){
        System.out.println("StudentReflect1的main方法执行了");
    }
}
