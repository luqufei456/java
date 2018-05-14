package com.yiran2.entity1.javaException.disposal;

/**
 * 异常捕获处理
 *
 * 	捕获处理，将异常获取，使用try/catch做分支处理
 *
 *  	try{
 *  		需要检测的异常；
 *  	} catch(异常对象) {
 *  		异常处理代码
 *  		可以调用异常的方法
 *  		通常我们只使用一个方法：printStackTrace打印异常信息
 *  	}
 * */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TryCatchDemo {
    public static void main(String[] args){
        //编译时异常
        //"d:/test.txt"
        //指定文件
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件路径："); // 默认是以项目目录为相对目录
        String path = sc.next();

        try{
            FileWriter fw = new FileWriter(path);
           /*fw.write("aaa");
            fw.close();
            System.out.println("输出成功");*/
        } catch(IOException e){
            System.out.println("您输入的路径有误");
            // 用来展示异常出现的位置和基本信息
            e.printStackTrace();
        }
    }
}
