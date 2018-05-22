package com.yiran2.entity2.iO.bufferedCharacterStream;

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.*;

/**
 * 高效字符流基本使用
 *
 *  高效原理:
 *  		缓冲区临时存储多个数据,一次调用底层资源,减少调用底层资源的次数,提高了程序运行的速度
 *
 *  高效缓冲流:
 *  		BufferedReader/BufferedWriter
 *
 *  高效流字符流的方法比普通流的方法更多
 *  高效流的构造方法接收普通流对象,在普通流的基础上增加了缓冲区
 *
 *  高效流write写出数据时,写出位置为缓冲区,并非目标资源.
 *  需要通过flush刷新方法将缓冲区的内容写出到目标文件中.
 *
 *  public void flush()刷新缓冲区,将内容写到目标文件中
 *  public void close()方法会调用flush方法
 * */

public class BufferedWriterReaderDemo1 {
    public static void main(String[] args){
        String path = "staticFile\\WriterTest2.txt";

        try {
            // 创建普通输出流对象
            FileWriter fw = new FileWriter(path);
            // 创建缓冲输出流对象
            BufferedWriter bw = new BufferedWriter(fw);
            // 写
            bw.write("我卢本伟，没有开挂！");
            // 刷新数据
            bw.flush();
            // 关闭缓冲流
            bw.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }

        try {
            // 创建普通读入流对象
            FileReader fr = new FileReader(path);
            // 创建缓冲读入流对象
            BufferedReader br = new BufferedReader(fr);
            // 读
            char[] chs = new char[1024];
            // 获取每次读到的个数
            int len;
            while ((len = br.read(chs)) != -1){
                System.out.print(new String(chs, 0, len));
            }
            // 关闭缓冲流，会自动先关闭普通流
            br.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }
    }
}
