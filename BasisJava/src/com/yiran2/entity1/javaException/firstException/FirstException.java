package com.yiran2.entity1.javaException.firstException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 异常
 *
 *	概念:代码运行当中可能出现的不正常情况
 *  			java当中将这些已经预见到的不正常情况,封装成了类.即异常类.
 *
 *  	产生异常:
 *  			当满足了异常产生条件时,会执行以下两个动作
 *  				创建异常对象
 *  				抛出异常对象
 *  			执行完该两个动作后,叫做产生了异常,只是这个过程是java自动执行的,我们看不到.
 *
 *  	异常分类:
 *  			Throwable
 *  				Error(程序无法处理)
 *  				Exception(可以通过程序处理的)
 *  					编译期异常(编译过程报错,必须处理)
 *  					运行期异常RuntimeException(编译期可以不处理,但是运行时可能会报错)
 *
 *  	处理:
 *  			捕获处理
 *  			声明抛出处理
 * */

public class FirstException {
    public static void main(String[] args) throws IOException {
        // 编译时异常
        // "d:/test.txt"

        // 指定文件
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入文件路径：");
        String path = sc.next();

        FileWriter fw = new FileWriter(path);
        //fw.write("hello hello hello~");
        //fw.close();

        System.out.println("运行时异常");
        System.out.println(10/0);
    }
}
