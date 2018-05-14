package com.yiran2.entity1.javaException.disposal;

/**
 * 单个运行时异常处理
 *
 * 	该异常在编译期不检查语法错误的.可以处理,也可以不处理.
 *
 * 	一般情况下,遇到java自身提供的运行时异常,都可以通过逻辑解决,避免异常产生.
 * 	常见运行时异常:空指针异常,索引越界异常,类型转换异常
 *
 * 	声明抛出处理
 * 	捕获处理
 * */

public class RunTimeOneDemo {
    public static void main(String[] args){
        try {
            System.out.println(10/0);
        } catch (ArithmeticException e){
            System.out.println("除数不能为0！");
        }

        System.out.println("-------------------");

        try {
            method();
        } catch (ArithmeticException e){
            System.out.println("除数不能为0！");
        }
    }

    // 运算方法
    public static void method() throws ArithmeticException{
        System.out.println(10/0);
    }
}
