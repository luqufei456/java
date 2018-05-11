package com.yiran2.entity1.javaClass.inheritance.superFunction;

import com.yiran2.entity1.javaClass.inheritance.Demo3.SubClass;

/**
 * 构造方法测试类
 *
 *    子类的构造方法会先调用父类的无参构造，从而保证父类的相关内容会先于子类内容的初始化
 *    子类就可以使用父类的内容了
 * */

public class TheTest {
    public static void main(String[] args){
        // 创建空参构造对象
        TheSubClass yiran = new TheSubClass(); // 可以看到，父类的构造方法先被调用
        // 创建有参构造对象
        TheSubClass chunjue = new TheSubClass("蠢觉");

        // 加上属性
        yiran.setName("依然");
        System.out.println(yiran.getName());

        System.out.println(chunjue.getName());
    }
}
