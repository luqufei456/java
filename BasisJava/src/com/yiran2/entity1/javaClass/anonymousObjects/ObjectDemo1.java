package com.yiran2.entity1.javaClass.anonymousObjects;

/**
 * 匿名对象的使用
 *
 *    匿名对象：没有引用的对象，没有名字的对象
 *    有名字(引用)的对象，使用引用调用该对象的方法
 *    匿名对象创建之后，立即使用对象自身调用对象即可
 *
 *    有引用的对象，可以通过引用，反复操作同一个对象，可以重用
 *    匿名对象因为没有引用变量指向，所以一般情况下只能使用一次
 * */

public class ObjectDemo1 {
    public static void main(String[] args){
        Person yiran = new Person();
        yiran.name = "yiran";
        // 可以
        System.out.println(yiran.name);
        new Person().name = "chunjue";
        // 输出为null  因为每次new都是一个新的对象，因为没有变量指向它  所以无法被保存 不能这样取值
        System.out.println(new Person().name);
    }
}
