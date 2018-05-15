package com.yiran2.entity1.javaException.disposal;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * finally代码块
 *
 *	在try/catch后可以追加finally代码块，其中的代码一定会被执行，通常用于资源回收。
 * */

public class FinallyDemo {
    public static void main(String[] args){
        //编译时异常
        //"d:/test.txt"
        //指定文件
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想要查看的文件路径:");
        String path = sc.next();

        try {
            FileReader fr = new FileReader(path);
            fr.close();
        } catch (IOException e){
            System.out.println("并没有该文件");
        } finally{
            System.out.println("我跟你说我一定会被触发的");
        }
    }
}
