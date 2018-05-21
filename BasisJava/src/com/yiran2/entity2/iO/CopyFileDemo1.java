package com.yiran2.entity2.iO;

import com.yiran2.entity1.javaClass.inheritance.Demo3.SubClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制
 *
 * 方法一：
 *	分析：
 *		1.	利用字节输入流关联ASCII码表完整版.doc文件
 *		2.	利用字节输出流关联ASCII码表完整版(副本).doc文件
 *		3.	循环从ASCII码表完整版.doc读一个字节,
 *			然后将这个字节写入到ASCII码表完整版(副本).doc,
 *			直到读到ASCII码表完整版.doc的末尾
 *		即先读后写
 *
 *
 * 方法二：
 *  分析：
 *		1.	定义一个长度为1024整数倍的字节数组
 *		2.	利用字节输入流关联ASCII码表完整版.doc文件
 *		3.	利用字节输出流关联ASCII码表完整版(副本).doc文件
 *		4.	循环从ASCII码表完整版.doc读一个字节数组,
 *			然后将这个字节数组中有效的内容写入到ASCII码表完整版(副本).doc,
 *			直到读到ASCII码表完整版.doc的末尾
 *		即先读后写
 * */

public class CopyFileDemo1 {
    public static void main(String[] args){
        CopyFileDemo1 admin = new CopyFileDemo1();
        String path = "staticFile\\鲁去非-个人简历-python开发.doc";
        String copyPath = "staticFile\\鲁去非-个人简历-python开发[副本].doc";
        try {
            // admin.copyMethod1(path, copyPath);
            // admin.copyMethod2(path, copyPath);
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }
        finally {
            System.out.println("不知道复制成功了还是失败了~");
        }
    }

    /** 使用一次一个字节的方式完成复制 */
    public void copyMethod1(String path, String copyPath) throws IOException{
        // 创建IO流对象绑定IO资源
        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(copyPath);

        // 读取数据，读一个字节，写一个字节
        // 先读再写，定义一个变量用于存储每次读到的字节
        int b;
        while ((b = fis.read()) != -1){
            // 后写
            fos.write(b);
        }

        // 关闭流,先开后关
        fos.close();
        fis.close();
    }

    /** 使用一次一个字节数组的方式完成复制 */
    public void copyMethod2(String path, String copyPath) throws IOException{
        // 创建IO流对象绑定IO资源
        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(copyPath);

        // 定义byte数组，用于存储读取的数据
        byte[] bytes = new byte[1024];

        // 定义变量，用于记录每次读到的长度
        int len;

        // 先读后写
        while ((len = fis.read(bytes)) != -1){
            // 起始点，读多少个长度，这里类似于String构造方法
            fos.write(bytes, 0, len);
        }

        // 关闭流
        fos.close();
        fis.close();
    }
}
