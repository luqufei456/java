package com.yiran.entity2.javaIO.fileWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter写入换行以及向文本末尾追加
 *
 * 如何实现数据的换行?
 * 		\n可以实现换行，但是windows系统自带的记事本打开并没有换行，这是为什么呢?
 * 		因为windows识别的换行不是\n，而是\r\n
 * 		windows:\r\n
 * 		linux:\n
 * 		mac:\r
 * 如何实现数据的追加写入?
 * 		FileWriter(String fileName, boolean append) 默认为false 不追加 而是重写
 * */

public class FileWriterDemo4 {
    public static void main(String[] args) throws IOException{
        // 创建输出流对象
        // FileWriter fw = new FileWriter("src\\com\\yiran\\entity2\\javaIO\\staticFile\\test3.txt");

        // 设置记事本换行字符串
        String newLine = "\r\n";

        // true 表示追加写入，默认值为false 不追加
        FileWriter fw = new FileWriter("src\\com\\yiran\\entity2\\javaIO\\staticFile\\test2.txt",true);

        // 测试一下第一次追加写入是否会自动换行
        fw.write("请问~换行了吗？");

        // 手动换行
        fw.write(newLine);

        fw.write("=v= 测试一下\\r\\n换行符");

        fw.close();
    }

}
