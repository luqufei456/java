package com.yiran2.entity2.iO.characterStream;

import java.io.FileReader;

/**
 * 字符输入流
 *
 *  输入流：
 *  		Reader(抽象类)
 *  		FileReader(基本字符输入流)
 *  构造方法：需要绑定IO资源
 *  		public FileReader(String name)
 *
 *  其他方法：读取时，返回数据时，使用int替代了char
 *  		int read()：读取一个字符；
 *  		int read(char[] c)：读取一个字符数组；
 *  		close()：由于每个IO流都需要绑定一个IO资源，在使用时，需要回收资源。
 * */

public class ReaderDemo1 {
    public static void main(String[] args){
        try {
            // 创建输入流对象
            FileReader fr = new FileReader("staticFile\\WriterTest.txt");

            // 一次读取一个字符
            int c;
            while ((c = fr.read()) != -1){
                System.out.print((char)c);
            }
            System.out.println();
            // 关闭输入流对象
            fr.close();


            // 一次性读取一个字符数组
            FileReader fr2 = new FileReader("staticFile\\WriterTest.txt");
            char[] chs = new char[1024];
            int len;
            while ((len = fr2.read(chs)) != -1){
                System.out.print(new String(chs, 0, len));
            }

        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }

    }
}
