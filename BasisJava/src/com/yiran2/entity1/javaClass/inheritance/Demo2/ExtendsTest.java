package com.yiran2.entity1.javaClass.inheritance.Demo2;

/**
 * 继承关系的测试类
 *
 * 当父类的成员变量用private修饰后,子类无法访问父类的成员变量,
 * 但是如果父类提供了public修饰的get/set方法,则子类可以通过get/set方法,正常访问父类的成员变量
 * */

public class ExtendsTest {
    public static void main(String[] args){
        // 创建子类对象
        Coder yiran = new Coder();
        // 使用子类可以通过public或protected修饰的get/set方法访问私有变量
        yiran.setName("依然");
        yiran.setAge(21);
        System.out.println(yiran.getName()+"的年龄为"+yiran.getAge());
        // 使用子类可以访问父类的非私有方法
        yiran.sleep();
        yiran.eat();
        yiran.touch();
        // 使用子类可以访问子类自身的成员方法
        yiran.code();
    }
}
