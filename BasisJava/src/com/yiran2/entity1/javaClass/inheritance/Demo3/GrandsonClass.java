package com.yiran2.entity1.javaClass.inheritance.Demo3;

/**
 * 孙子类
 *
 * Sun1类直接继承Zi1类,间接继承Fu1类与Object类
 * 继承存在多层继承
 * */

public class GrandsonClass extends SubClass {
    public void isMe(){
        System.out.println("孙子类：没错，是我 我来了！");
    }
}
