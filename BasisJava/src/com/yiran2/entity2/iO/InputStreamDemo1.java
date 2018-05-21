package com.yiran2.entity2.iO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流--即读入数据
 *
 * InputStream:字节输入流的根类,定义了所有字节输入流应该具备的方法
 * FileInputStream:文件输入流是用于从文件当中读取数据的输入流
 *
 * public int read() 一次读取一个字节,返回的就是这个字节本身,读取到文件末尾返回-1
 *
 *
 * 一次读取一个字节数组
 * int read(byte[] b)：读取一个字节数组
 * 						返回值是本次读取到的字节的个数
 * 						参数用于每次存储字节数据的数组
 * 						读取到文件末尾返回-1
 * */

public class InputStreamDemo1 {
    public static void main(String[] args){
        InputStreamDemo1 admin = new InputStreamDemo1();
        try {
            admin.method1("staticFile\\OutPutTest1.txt");
            admin.method2("staticFile\\OutPutTest1.txt");
        } catch (Exception e){
            System.out.println("路径有问题");
        }
    }

    public void method1(String path) throws IOException{
        // 创建IO流对象，绑定IO资源
        FileInputStream fis = new FileInputStream(path);

        // 读取数据
        // int c = fis.read();
        // System.out.println(c);
        // 将byte转为二进制字符串
        // System.out.println(Integer.toBinaryString(c));

        // 使用循环读取
        int i;
        while ((i = fis.read()) != -1){
            System.out.println(i);
        }

        // 关闭IO流对象
        fis.close();
    }

    public void method2(String path) throws IOException{
        // 创建IO流对象，绑定IO资源
        FileInputStream fis = new FileInputStream(path);

        // 读取数据
        // byte[] bytes = new byte[3];
        // int len = fis.read(bytes);
        // System.out.println(len);
        // System.out.println(new String(bytes, 0, len));

        // 定义数组，用于接收每次读取的字节数据，一般长度为1024或其整数倍
        byte[] bytes = new byte[1024];
        // 定义变量，用于记录每次读到的字节长度
        int len;
        // 循环读取，直到文件末尾
        while ((len = fis.read(bytes)) != -1){
            // 将字节数组变成字符串,方便观察(通过字符串的构造方法)
            // 本次读取到几个字节,就转换成几个字节为字符串
            String str = new String(bytes, 0, len);
            System.out.println(str);
        }

        // 关闭流
        fis.close();
    }
}
