package com.yiran.entity2.javaIO.buffered;

import java.io.*;

/**
 * 缓冲流BufferedWriter、BufferedReader的基本使用
 * BufferedWriter:
 *      将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
 * BufferedReader:
 *      从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
 *
 * 构造方法：
 *      new BufferedWriter(FileWriter fw, int sz)
 *          前者为输出流对象，后者为缓存区容量，容量满了之后会自动写入
 *          这样就减少了 IO 次数 达到加速的效果
 *      BufferedReader 同理
 * */

public class BufferedDemo1 {
    public static void main(String[] args) throws IOException{
        /*// 创建输出流对象
        FileWriter fw = new FileWriter("src\\com\\yiran\\entity2\\javaIO\\staticFile\\Buffered.txt");
        // 创建输出缓冲流对象
        // 最后全部输出成功，可以看到，即使最后不满足512k的容量，最后也可以成功输出
        BufferedWriter bw = new BufferedWriter(fw,512);*/

        // 创建输入流对象
        FileReader fr = new FileReader("src\\com\\yiran\\entity2\\javaIO\\fileWriter\\FileWriterDemo1.java");
        // 创建输入缓冲流对象
        BufferedReader br = new BufferedReader(fr,512);

        /*// 一次读写一个字符
        int ch;
        while ((ch = br.read()) != -1){
            System.out.print(ch);
        }*/

        // 一次读写一个字符数组
        char[] chs = new char[1024];
        int len;
        while ((len = br.read(chs)) != -1){
            /**
             * 为什么直接输出chs 会发现后面一段重复了？
             * 因为read()重写char[]时，最后一次的长度不满足char[]的长度
             * 所以前面的部分被重写了，后面的部分还是保留上一次的信息，直接输出就会导致重复
             * 所以要使用 new String(chs,0,len) 来将最后一次重写的部分转为字符串输出
             * 这样就不会出现重复输出前面一次重复的内容部分
             * */

            System.out.print(new String(chs,0,len)); // 使用String输出没有问题
        }


        // 释放资源
        fr.close();
        br.close();
        // bw.close();
    }
}
