package com.yiran2.entity1.javaGenerics.interType;

/**
 * 实现泛型接口的普通类的测试类
 *
 * 泛型接口:
 * 		定义：接口后<变量>如： interface B<T>{使用T完成接口定义}
 *		使用：
 *			1、定义类时确定类型
 *			2、始终不确定类型，直到创建对象时确定类型
 * */

public class MyClassInterDemo {
    public static void main(String[] args){
        // 创建这个确定了类型为String的类的实例
        MyClassInter1 mci1 = new MyClassInter1();
        mci1.method("这是依然的第一个java泛型接口，被实现为String类型");
        // 测试是否定义了确定类型，就不能使用 接收了别的类型的方法, 结论是可以
        mci1.intShow(10086);
        System.out.println();

        // 创建实现了泛型接口的泛型类的实例
        // 基本类型不能作为原始的类型，这时候就会用到包装类
        MyClassInter2<Integer> mci2 = new MyClassInter2<Integer>();
        mci2.method(12121);
    }
}
