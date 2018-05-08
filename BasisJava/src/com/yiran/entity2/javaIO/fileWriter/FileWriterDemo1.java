package com.yiran.entity2.javaIO.fileWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A:FileWriter向文件中写数据操作步骤:
 *      a:使用FileWriter流关联文件
 *      b:利用FileWriter的写方法写数据
 *      c:利用FileWriter的刷新方法将数据从内存刷到硬盘上
 *      d:利用FileWriter的关闭流方法将释放占用的系统底层资源
 *
 * B:FileWriter方法:
 *  构造方法
 *      FileWriter(String fileName)  传入一个文件的路径
 *  成员方法
 *      void write(String str)  向文件中写str
 *      void flush()  将内存中的数据刷新到文件中
 *      void close()  关流释放系统底层资源
 *
 * FileWriter往文件中写数据
 *
 * 需求：往文件中写数据
 * 		写数据--输出流--FileWriter
 *
 * FileWriter:
 * 		FileWriter(String fileName):传递一个文件名称
 *
 * 输出流写数据的步骤：
 * 		A:创建输出流对象
 * 		B:调用输出流对象的写数据的方法
 * 		C:释放资源
 * */

public class FileWriterDemo1 {
    //  throws IOException 不加会报错 这里是异常 要么用这个  要么加  try
    public static void main(String[] args) throws IOException{
        // 创建输出流对象 这里 \\ 是转义 \  一个是\  一个是转义符
        FileWriter fw = new FileWriter("H:\\StudyJava\\BasisJava\\src\\com\\yiran\\entity2\\javaIO\\staticFile\\test1.txt");
        /*
         * 创建输出流对象做了哪些事情:
         * 		A:调用系统资源创建了一个文件
         * 		B:创建输出流对象
         * 		C:把输出流对象指向文件
        * */

        // 调用输出流对象的写数据方法---写一个字符串
        fw.write("hello~ 我是依然，这是我写的第一个javaIo流~");
        // 数据并没有被直接写到文件，而是写到了内存缓冲区
        fw.flush();

        // 释放资源，通知系统释放和该文件有关的资源
        fw.close();
    }
}
