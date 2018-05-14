package com.yiran2.entity1.javaException.disposal;

import java.io.IOException;

/**
 * 异常声明抛出处理 和捕获处理不一样
 *
 *   在某个方法的声明上,让它(这个方法)抛出这个产生的异常,自己不处理,谁调用这个方法,谁处理
 *  方法声明上加 throws 异常类名
 *
 *  如:
 *  		方法a中产生了异常,声明抛出
 *  		方法b调用方法a,则该异常由a转向了b
 *
 *  一般情况下,main方法是不会声明抛出异常的,因为该方法抛出,直接抛出给了JVM,
 *  JVM的默认处理机制是终止程序运行,则这样处理,相当于没有处理!
 *
 *  这个例子最后相当于抛来抛去，最后还是给main中的捕获处理了
 * */

import java.util.Scanner;
import java.io.FileWriter;

public class ThrowsDemo {
    public static void main(String[] args){
        try {
            method2();
        }catch (IOException e){
            System.out.println("文件有误");
            e.printStackTrace();
        }
    }

    public static void method2() throws IOException{
        method();
    }

    /*
    * 该方法的代码中,可能会产生IOException异常,该方法处理的方式是声明如果出现该异常,
    * 就抛出该异常,自身并不处理,哪个方法调用该方法,哪个方法处理
    * */

    public static void method() throws IOException{
        //编译时异常
        //"d:/test.txt"
        //指定文件
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件路径：");
        String path = sc.next();

        FileWriter fw = new FileWriter(path);
        System.out.println("输出成功了");
    }
}
