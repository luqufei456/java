package com.yiran2.entity2.javaRecursion;

import java.io.File;

/**
 * 递归打印多级文件夹路径
 *
 *  打印一个文件夹内所有的文件夹和文件路径
 *
 *  1:定义方法,接受文件夹,打印该文件夹中所有的文件路径
 *
 *  2:获取该文件夹中的所有文件对象
 *  3:判断该文件对象是文件还是文件夹
 *  		如果是文件,打印路径
 *  		如果是文件夹,调用方法,打印该文件夹中所有的文件路径
 * */

public class RecursionTest2 {
    public static void main(String[] args){
        File dir = new File("./");
        new RecursionTest2().method(dir);
    }

    public void method(File dir){
        // 获取该文件夹下的所有文件对象
        File[] files = dir.listFiles();
        // 依次获取所有的文件对象
        System.out.println(); // 这样能保证同一个文件夹的在同一行显示
        for (File file : files){
            // 判断是文件还是文件夹
            if (file.isFile()){
                // 如果是文件，打印路径
                System.out.print(file.getAbsolutePath());
                System.out.print("      ");

            }
            else{
                // 如果是文件夹，则递归
                method(file);
            }
        }

    }
}
