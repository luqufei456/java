package com.yiran2.entity1.twoModified.staticDemo;

/**
 * 静态成员的访问
 *
 * 静态成员只能直接访问静态成员
 *
 * 原因为:静态内容优先于对象存在
 *
 *      静态内容与类同步存在，所以有类的时候，静态成员已经加载完成，而对象并没有完成
 *          先出现的无法使用后来才会有的东西，后出现的可以使用在此之前就有的东西
 * */

public class StaticDemo2 {
    private String name;
    private static String country = "中国";

    public static void main(String[] args){

    }

    // 普通方法
    public void normalMethod(){
        System.out.println("普通方法访问静态变量："+this.country);
    }

    // 静态方法 报错
    public static void method(){
        // System.out.println("静态方法访问普通成员"+this.name);
    }
}
