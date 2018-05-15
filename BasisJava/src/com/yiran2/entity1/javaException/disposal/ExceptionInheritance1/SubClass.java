package com.yiran2.entity1.javaException.disposal.ExceptionInheritance1;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * 子类中重写父类的方法
 * */

public class SubClass extends SuperClass {
    @Override
    public void method() throws IOException,ParseException{
        // 子类的方法体
    }

    /*@Override // 报错
    public void method1() throws IOException{}*/

    public void method1(){
        // 子类的方法体
        // 编译时异常
        // "d:/test.txt"
        // 指定文件
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想要查看的文件：");
        String path = sc.next();
        try {
            FileReader fr = new FileReader(path);
        } catch(IOException e){
            System.out.println("您输入的文件不存在");
        }

    }
}
