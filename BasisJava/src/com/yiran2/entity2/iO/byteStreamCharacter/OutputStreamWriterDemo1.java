package com.yiran2.entity2.iO.byteStreamCharacter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 写出转换流 的使用
 *
 *  	需求:
 *  		已经具备字节流,绑定了IO资源
 *  		需要将字节流转成字符流
 *
 *  	此时,可以使用转换流,接收一个字节流对象,进行字符流的操作.
 *  	转换流本身就是字符流
 *
 *  	转换流:
 *  		Reader:
 *  			InputStreamReader可以完成字节输入流转换为字符输入流
 *  		Writer:
 *  			OutputStreamWriter可以完成字节输出流转换为字符输出流。
 *
 *  	则转换流的使用方法:
 *  		构造方法传入字节流对象
 *  		自身调用字符流的方法
 * */

public class OutputStreamWriterDemo1 {
    public static void main(String[] args){
        String path = "staticFile\\转换流测试.txt";
        try {
            // 创建字节流输出对象
            FileOutputStream fos = new FileOutputStream(path);
            // 将字节流转为字符流，即通过字节流对象创建转换流对象
            // 创建转换流对象时，可以指定编码方式
            OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
            // 使用字符流方法
            osw.write("hello Mr.Dj, 这节奏不要停~\r\n");;
            osw.write("我脑袋里在开parttry，不嗨都不行~");
            // 与缓冲流类似，转换流包含字节流，所以关闭转换流，字节流自动关闭
            osw.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }

    }
}
