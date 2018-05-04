package com.yiran.entity;

/**
 * 如何调用构造方法呢？
 * 通过new关键字调用
 * 格式：类名  对象名 = new 构造方法(...);
 * 也就是创建对象的格式
 * */

public class ConstructorUse {
    public static void main(String[] args){
        ConstructorDefine stu1 = new ConstructorDefine();
        System.out.println("--------无参构造方法--------");
        System.out.println("public Student()");
        stu1.setName("chunjue");
        stu1.setAge(25);
        stu1.show();

        System.out.println("--------有参构造方法--------");
        ConstructorDefine stu2 = new ConstructorDefine("yiran");
        System.out.println("public Student(String name)");
        stu2.show();

        ConstructorDefine stu3 = new ConstructorDefine(21);
        System.out.println("public Student(int age)");
        stu3.show();

        ConstructorDefine stu4 = new ConstructorDefine("yiran",21);
        System.out.println("public Student(String name,int age)");
        stu4.show();

    }

}
