package com.yiran2.entity2.iO.bufferedByteStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 高效字节流
 *
 *    高效原理：缓冲区临时存储多个数据，一次调用底层资源，减少调用底层资源的次数，提高了程序运行的速度
 *
 *    高效字节缓冲流：
 *    	BufferedInputStream/BufferedOutputStream
 *
 *    高效流的方法与普通流完全一致
 *    高效流使用普通流对象作为构造方法参数。在普通流的基础上增加了缓冲区,可以定义缓冲区大小，有默认值。
 *
 *    高效流write写出数据时，写出位置为缓冲区，并非目标资源。
 *    需要通过flush刷新方法将缓冲区的内容写出到目标文件中。
 *
 *    public void flush()	刷新缓冲区，将内容写到目标文件中
 *    public void close()	会调用flush方法
 * */

public class BufferedStreamDemo1 {
    public static void main(String[] args) throws IOException{
        // 以高效读入流为例
        // 创建普通读入流对象
        String path = "staticFile\\FileTest.txt";
        FileInputStream fis = new FileInputStream(path);
        // 穿件高效读入流对象，这里自己定义缓冲区为4096 默认值为8192 单位字节
        BufferedInputStream bis = new BufferedInputStream(fis, 4096);

        // 高效流-即缓冲流与普通流方法一致，写出数据
        byte[] bytes = new byte[1024];
        int len;

        while ((len = bis.read(bytes)) != -1){
            // 读取中文会乱码，因为一个中文占了2个字节 这里使用String的构造方法
            // 使用gbk格式但是，如果1024 和1025这两位为一个汉字，那么还是会出错，
            // 所以建议用字符流来读取中文
            System.out.println(new String(bytes, 0, len,"gbk"));
        }

        bis.close();
    }
}
