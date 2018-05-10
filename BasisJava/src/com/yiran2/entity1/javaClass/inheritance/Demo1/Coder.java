package com.yiran2.entity1.javaClass.inheritance.Demo1;

/**
 * 程序员类
 *
 * 定义子类程序员类,继承人类
 * 在人类共性内容的基础上,添加编程功能
 * 这就属于 is like a （像是一个）
 * */

public class Coder extends Person {
    public void code(){
        System.out.println("写什么bug？ 摸了！");
    }
}
