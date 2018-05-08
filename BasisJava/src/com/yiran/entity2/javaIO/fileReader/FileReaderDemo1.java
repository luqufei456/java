package com.yiran.entity2.javaIO.fileReader;

import java.io.FileReader;
import java.io.IOException;

/**
 * 从文件中读数据并显示到控制台
 *
 * 需求：从文件中读数据并显示到控制台
 * 		读数据--输入流--FileReader
 *
 * FileReader:
 * 		FileReader(String fileName):传递文件名称
 *
 * 输入流读文件的步骤：
 * 		A:创建输入流对象
 * 		B:调用输入流对象的读数据方法
 * 		C:释放资源
 *
 * 读数据时，会从上一次读过的地方开始读，不会重复读，返回值为-1时，表示读完了
 *
 * java.io.FileNotFoundException: fr.txt (系统找不到指定的文件。)
 * */

public class FileReaderDemo1 {
    public static void main(String[] args) throws IOException{
        // 创建输入流对象 这里读取一下之前写是输出流演示1的java文件
        FileReader fr = new FileReader("src\\com\\yiran\\entity2\\javaIO\\fileWriter\\FileWriterDemo1.java");

        /*// 第一次读数据
        int ch1 = fr.read();
        System.out.println(ch1);
        System.out.println((char)ch1);

        // 第二次读数据
        int ch2 = fr.read();
        System.out.println(ch2);
        System.out.println((char)ch2);*/

        // 这样读，代码重复率太高，采用循环来读取，返回值为-1时，表示读完了
        // int ch = fr.read(); 如果这样定义，就相当于只读了一次，死循环
        int ch;
        // 当读出为 -1时 代表读完了，可以停下来
        while ((ch = fr.read()) != -1){
            System.out.print((char)ch); // 换行符之类的也能读出
        }

        // 释放资源
        fr.close();

    }
}
