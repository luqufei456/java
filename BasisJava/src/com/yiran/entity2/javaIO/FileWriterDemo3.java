package com.yiran.entity2.javaIO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * void write(String  str):
 *      写一个字符串数据
 * void write(String  str,int  index,int  len):
 *      写一个字符串中的一部分数据
 * void write(int  ch):
 *      写一个字符数据,这里写int类型的好处是既可以写char类型的数据，也可以写char对应的int类型的值。'a',97
 * void write(char[]  chs):
 *      写一个字符数组数据
 * void write(char[]  chs,int  index,int  len):
 *      写一个字符数组的一部分数据
 * */

public class FileWriterDemo3 {
    public static void main(String[] args) throws IOException{
        // 创建输出流对象
        FileWriter fw = new FileWriter("src\\com\\yiran\\entity2\\javaIO\\staticFile\\test3.txt");

        String newLine = "\r\n";

        // void write(String str):写一个字符串数据
        fw.write("(⊙﹏⊙)");
        fw.write(newLine); // 换行

        // void write(String str,int index,int len):写一个字符串中的一部分数据
        // 可以看到，不是 off - len  off是起始点 len是几个 长度的意思
        fw.write("abcdefg",0,2);
        fw.write(newLine);
        fw.write("abcdefg",2,1);
        fw.write(newLine);

        // void write(int ch):写一个字符数据,这里写int类型的好处是既可以写char类型的数据，也可以写char对应的int类型的值。'a',97
        fw.write('a');
        fw.write(newLine);
        fw.write(97);
        fw.write(newLine);

        // void write(char[] chs):写一个字符数组数据
        char[] chs = {'a','b','c','d','e'};
        fw.write(chs);
        fw.write(newLine);

        // void write(char[] chs,int index,int len):写一个字符数组的一部分数据
        fw.write(chs,3,1);
        fw.write(newLine);

        fw.close();
    }
}
