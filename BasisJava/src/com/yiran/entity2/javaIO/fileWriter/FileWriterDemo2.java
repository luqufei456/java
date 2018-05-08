package com.yiran.entity2.javaIO.fileWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter注意事项：
 *
 * 输出流写数据的步骤：
 * 		A:创建输出流对象
 * 		B:调用输出流对象的写数据方法，并刷新缓冲区
 * 		C:释放资源
 *
 * 相对路径：相对当前项目而言的，在项目的根目录下(a.txt)
 * 绝对路径：以盘符开始的路径(d:\\a.txt)
 *
 * close()和flush()方法的区别：
 * 		flush():刷新缓冲区。流对象还可以继续使用。
 * 		close():先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。
 * */

public class FileWriterDemo2 {
    public static void main(String[] args) throws IOException{
        // 获取项目根目录
        String relativelyPath=System.getProperty("user.dir");
        // 创建输出流对象
        // FileWriter fw = new FileWriter("H:\\StudyJava\\BasisJava\\src\\com\\yiran\\entity2\\javaIO\\staticFile\\test1.txt");
        // 绝对路径不可以用 ../ 返回上一目录 这里使用相对路径
        FileWriter fw = new FileWriter("src\\com\\yiran\\entity2\\javaIO\\staticFile\\test2.txt");

        // 调用输出流对象的写数据方法，并刷新缓冲区
        fw.write("这是第二个~");
        fw.flush();
        fw.write("依然~desu"); // 最后发现并没有换行 还是要自己加换行符
        fw.flush(); // 试试第二次输入不用flush  看看close会不会刷新缓冲区 结论是 close也刷新了缓冲区

        // 释放资源
        fw.close();
    }
}
