package com.yiran2.entity1.javaException.disposal.customException;

import java.util.Scanner;

/**
 * 自定义异常的测试类
 *
 *  自定义异常:
 * 		编译时异常继承Exception，运行时异常继承RuntimeException。
 * 		关键字 throw 抛出异常
 *
 * 	另外不得不说异常处理中的throws和throw的区别了。
 *
 *      1、throws出现在方法的声明中，表示该方法可能会抛出的异常，允许throws后面跟着多个异常类型
 *
 *      2、throw出现在方法体中，用于抛出异常。当方法在执行过程中遇到异常情况时，
 * 将异常信息封装为异常对象，然后throw。
 *
 *      同样为抛出异常，一个是声明中抛出，一个是方法体中抛出,一个可以抛出多个，一个抛出单个
 *
 * 		回忆产生异常:
 * 			创建异常对象
 * 			抛出异常
 * */

public class U18Demo {
    public static void main(String[] args){
        // 当年龄小于18岁时会产生异常
        Scanner sc = new Scanner(System.in);
        System.out.print("年龄：");
        int age = sc.nextInt();

        if (age < 18){
            // 产生异常
            // 创建异常对象
            U18Exception u18 = new U18Exception("年龄小于18岁");

            try {
                // 抛出异常
                throw u18;
            } catch (U18Exception e){ // 捕获异常
                System.out.println("年龄不满足要求");
                e.printStackTrace();
            }
        }

    }
}
