package com.yiran.entity2.javaIO.fileReader;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader读数据一次读取一个字符数组的数据
 *
 * 输入流读文件的步骤：
 *    A：创建输入流对象
 *    B：调用输入流对象的读数据方法
 *    C：释放资源
 *
 * int read(char[] cbuf)  读取字符，并将字符读入数组 返回的int类型是读取的长度
 *
 * char[] cbuf 读取时，也一样 返回值为-1表示读取完了 意思是没有读到数据
 *
 * */

public class FileReaderDemo2 {
    public static void main(String[] args) throws IOException{
        // 创建输入流对象
        FileReader fr = new FileReader("src\\com\\yiran\\entity2\\javaIO\\fileWriter\\FileWriterDemo1.java");

        /*
        // 定义字符数组
        char[] chs = new char[5];

        // 第一次读取
        int len = fr.read(chs); // 返回的是读取的长度
        System.out.println(len);
        // System.out.println(chs); 因为String 本质就是一个字符数组，所以字符数组也可以直接输出
        String str = new String(chs,0,len);
        System.out.println(str);

        // 第二次读取
        len = fr.read(chs);
        // 第二次读取就会发现 长度没有改变，并不是说 第一次 1-5 第二次 6-10  而是固定的，这一次读了5个字符
        // 而每次读取多少个字符，根据定义的字符数组的长度来算
        System.out.println(len);
        str = new String(chs,0,len);
        System.out.println(str);
        */

        char[] chs = new char[5];
        int len;
        String str;
        // A:fr.read(chs)
        // B:len=fr.read(chs)
        // C:len!=-1
        while ((len = fr.read(chs)) != -1){
            str = new String(chs,0,len);
            System.out.print(str);
        }

        fr.close();

    }
}
