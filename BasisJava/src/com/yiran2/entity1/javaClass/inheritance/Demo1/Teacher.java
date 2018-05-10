package com.yiran2.entity1.javaClass.inheritance.Demo1;

/**
 * 老师类
 *
 * 定义子类老师类,继承人类
 * 在人类共性内容的基础上,添加教学功能
 * 同样属于 is like a (像是一个)
 * */

public class Teacher extends Person {
    public void teach(){
        System.out.println("教什么学生？ 摸了！");
    }
}
