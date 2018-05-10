package com.yiran2.entity1.javaClass.inheritance.Demo3;

/**
 * 子类
 *
 * 一个子类不能拥有多个直接父类,继承只支持单继承
 * public class Zi1 extends Fu1,Fu2{
 *
 * }
 *
 * 一个子类可以有一个父类
 * */

public class SubClass extends SuperClass1{
    String gender;

    public void touch(){
        System.out.println("子类：我  摸了！");
    }
}
