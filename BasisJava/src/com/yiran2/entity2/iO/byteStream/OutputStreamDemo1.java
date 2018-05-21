package com.yiran2.entity2.iO.byteStream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流的使用
 *
 *  OutputStream:字节输出流的根类,定义了所有字节输出流应该具备的方法
 *  FileOutputStream:文件输出流是用于将数据写入文件的输出流
 *
 *  public abstract void write(int b)	写出一个字节
 *  public void write(byte[] b)		写出一个字节数组的字节
 *  public void close()				关闭IO资源
 *
 *
 *  public void write(byte[] b)	写出一个字节数组的字节
 *
 *  输出流的源代码实现:如果输出时没有该文件,则会先创建该文件,再输出数据
 *  默认的写出是覆盖掉了文件以前的内容,如果想每次运行程序写出数据不覆盖之前的内容,使用特定的构造方法
 *  public FileOutputStream(String name,boolean append) append参数:是否追加数据
 *
 *  在FileOutputStream的构造方法当中,指定的io资源可以是文件对象,也可以是文件路径,其本质是相同的.
 *  一般情况下直接使用给予文件路径的方式创建IO流对象,因为源代码中会自动帮助我们创建File对象.
 * */

public class OutputStreamDemo1 {
    public static void main(String[] args) throws IOException{
        // 创建IO流对象
        FileOutputStream fos = new FileOutputStream("staticFile\\OutPutTest1.txt");

        // 输出数据，使用字节数组
        byte[] bytes = {86,21,42};
        fos.write(bytes);

        // 关闭资源
        fos.close();
    }
}
