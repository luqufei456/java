package com.yiran2.entity1.javaException.disposal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 多异常处理
 *
 *  	多异常处理一:
 * 		声明抛出处理,直接抛出多个异常即可
 *
 * 	    多异常处理二:
 * 		    一个try多个catch的方式
 *
 * 	java是中断异常的处理方式
 * */

public class RunTimeMoreDemo {
    public static void main(String[] args){
        try {
            method2();
        } catch (ArithmeticException ae){
            System.out.println("您的除数不能为0");
        } catch (IOException ie){
            System.out.println("你要访问的文件不存在");
        }
    }

    // 一个方法声明抛出多个异常
    public static void method2() throws ArithmeticException,IOException {
        System.out.println(10/1);
        System.out.println("逻辑1完成");
        method();
        System.out.println("逻辑2完成");
    }

    // 一个方法抛出一个异常
    public static void method() throws IOException {
        // 指定文件查看
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件路径：");
        String path = sc.next();

        FileReader fw = new FileReader(path);
    }
}
