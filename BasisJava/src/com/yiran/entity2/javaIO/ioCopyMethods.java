package com.yiran.entity2.javaIO;

import java.io.*;

/**
 * 复制文本文件(5种方式)
 *
 *  数据源：
 * 		FileWriterDemo.java
 * 目的地：
 * 		Copy.java
 * */

public class ioCopyMethods {
    public static void main(String[] args) throws IOException{

    }

    // 基本流  一次读写一个字符
    public void method1(String srcFileName, String destFileName) throws IOException{
        // 创建输入流对象
        FileReader fr = new FileReader(srcFileName);
        // 创建输出流对象
        FileWriter fw = new FileWriter(destFileName);

        // 一次读写一个字符
        int ch;
        while ((ch = fr.read()) != -1){
            fw.write(ch);
        }

        // 释放资源
        fw.close();
        fr.close();
    }

    // 基本流 一次读写一个字符数组
    public void method2(String srcFileName, String destFileName) throws IOException{
        // 创建输入流对象
        FileReader fr = new FileReader(srcFileName);
        // 创建输出流对象
        FileWriter fw = new FileWriter(destFileName);

        // 一次读写一个字符数组
        char[] chs = new char[1024];
        int len;
        while ((len = fr.read(chs)) != -1){
            fw.write(chs,0,len);
        }

        // 释放资源
        fw.close();
        fr.close();
    }

    // 缓冲流一次读写一个字符
    public void method3(String srcFileName, String destFileName) throws IOException{
        // 创建输入缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader(srcFileName));
        // 创建输出缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(destFileName));

        // 一次读写一个字符
        int ch;
        while ((ch = br.read()) != -1){
            bw.write(ch);
        }

        // 释放资源
        bw.close();
        br.close();
    }

    // 缓冲流一次读写一个字符数组
    public void method4(String srcFileName, String destFileName) throws IOException{
        // 创建输入缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader(srcFileName));
        // 创建输出缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(destFileName));

        // 一次读写一个字符数组
        char[] chs = new char[1024];
        int len;
        while ((len = br.read(chs)) != -1){
            bw.write(chs,0,len);
        }

        // 释放资源
        bw.close();
        br.close();
    }

    // 缓冲流一次读写一个字符串 使用readLine()和 newLine()
    public void method5(String srcFileName, String destFileName) throws IOException{
        // 创建输入缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader(srcFileName));
        // 创建输出缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(destFileName));

        // 缓冲流一次读写一个字符串
        String line;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine(); // 换行符
            bw.flush();
        }

        // 释放资源
        bw.close();
        br.close();
    }


}
