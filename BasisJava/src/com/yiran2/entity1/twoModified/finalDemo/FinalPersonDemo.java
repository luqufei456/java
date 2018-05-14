package com.yiran2.entity1.twoModified.finalDemo;

import com.yiran2.entity1.javaClass.polymorphism.test1.Person;

/**
 * final修饰变量
 *
 *  final是最终修饰符，可以修饰类、成员方法、变量
 *
 *  final修饰的类无法被继承。
 *  final修饰的方法无法被重写。
 *  final修饰的变量无法被再次赋值,必须被赋值。(包括局部变量与成员变量)
 *
 *  现实开发过程中遇到的最常见成员常量的情况,连续使用public static final在一个类中定义一个常量,采取直接给常量赋值的方式.
 *  注意常量的命名规则:所有字母均大写,用_连接
 * */

public class FinalPersonDemo {
    public static final double PI = 3.1415926;

    public static void main(String[] args){
        // final修饰的变量为常量，无法再次赋值
        int a = 10;
        a = 20;

        final int b = 20;
        // 被final修饰的变量不能二次赋值
        // b = 10;

        // 使用静态常量
        double r = 2.5;
        double area = r * r * FinalPersonDemo.PI;
        System.out.println(area);

        // 为引用变量二次赋值是指，将该变量指向另一个地址，用final修饰过的引用变量无法指向另一个地址
        final FinalPerson yiran = new FinalPerson();
        yiran.setName("依然");
        System.out.println(yiran.getName());

        // 不能指向新的地址
        // yiran = new FinalPerson();
    }
}
