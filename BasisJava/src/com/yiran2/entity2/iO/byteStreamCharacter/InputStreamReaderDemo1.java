package com.yiran2.entity2.iO.byteStreamCharacter;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 读入转换流 的使用
 *
 * 	需求:
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
 *
 *  可以看到，使用字节流时，因为转码的问题，会中文乱码
 * */

public class InputStreamReaderDemo1 {
    public static void main(String[] args){
        // 对比字节流操作字符和字符流操作字符的区别
        String path = "staticFile\\转换流测试.txt";

        // 普通字节流
        try {
            FileInputStream fis = new FileInputStream(path);
            /*byte[] bytes = new byte[1024];
            int len;
            // 读 使用byte数组，暂时看不会乱码，如果单个读，一个中文
            // 占2字节，就被断开了，出现乱码
            while ((len = fis.read(bytes)) != -1){
                System.out.print(new String(bytes, 0, len));
            }*/

            int i;
            // 单个读
            while ((i = fis.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println();
            // 关闭字节流
            fis.close();
        } catch(Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }

        // 转换流-也是字符流的一种
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            int x;
            // 读
            while ((x = isr.read()) != -1){
                System.out.print((char)x);
            }
            System.out.println();
            // 关闭字节流
            isr.close();
        } catch(Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }
    }
}
