package com.yiran.entity2.javaIO.useMethods;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件复制拷贝 利用字符数组 char[]
 *
 * 需求：
 * 		把项目路径下的FileWriterDemo.java中的内容复制到项目路径下的Copy.java中
 *
 * 文件复制也是有规律可循的，也就是说有套路。
 *
 * 数据源：
 * 		FileWriterDemo.java -- 读数据 -- FileReader
 * 目的地：
 * 		Copy.java -- 写数据 -- FileWriter
 * */

public class CopyDemo1 {
    public static void main(String[] args) throws IOException{
        // 创建输入流对象
        FileReader fr = new FileReader("src\\com\\yiran\\entity2\\javaIO\\fileWriter\\FileWriterDemo1.java");

        // 创建输出流对象
        FileWriter fw = new FileWriter("src\\com\\yiran\\entity2\\javaIO\\staticFile\\copy1.java"); // java后缀也可以

        char[] chs = new char[10];
        int len;
        String str;

        while ((len = fr.read(chs)) != -1){
            str = new String(chs,0,len);
            fw.write(str);
        }

        // 先打开的后关闭，后打开的先关闭
        fw.close();
        fr.close();

    }

}
