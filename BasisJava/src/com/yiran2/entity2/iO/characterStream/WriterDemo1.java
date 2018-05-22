package com.yiran2.entity2.iO.characterStream;

import java.io.FileWriter;

/**
 * 字符输出流
 *
 * 	字符输出流:
 *  		Writer字符输出流的根类,具备所有字符输出流所应该具备的方法
 *  		FileWriter文件字符输出流
 *
 *	构造方法：需要绑定IO资源
 *  		public FileWriter(String fileName)	创建覆盖写出对象
 *  		public FileWriter(File file,boolean append)	创建指定是否追加写出对象
 *
 *  	普通方法:
 *  		write(int n)：输出一个字符(使用int替代了char)
 *  		write(char[] c)：输出一个字符数组
 *  		write(char[] c , int off , int len)：输出字符数组的一部分
 *  		write(String s)：输出一个字符串
 *  		write(String s , int off , int len)：输出字符串的一部分
 *  			字符串>>>二进制1010101  >>写出二进制101010  >>
 *  			文本文件打开时,将二进制101010翻译成对应的字符显示
 *
 *  		flush()：刷新缓冲区,将内容写出到指定IO资源,字符流都带缓冲区,都必须刷新.
 *  			将"我爱JAVA"字符打碎成二进制字节10xxx1010x 写到缓冲区中,通过刷新一次性写出
 *  		close()：由于每个IO流都需要绑定一个IO资源,在使用时,需要回收资源.
 *  			而字符流输出流在关闭时,会先调用flush方法.
 * */

public class WriterDemo1 {
    public static void main(String[] args){
        try {
            // 创建输出流对象
            FileWriter fw = new FileWriter("staticFile\\WriterTest.txt");

            // 输出数据
            fw.write('a');
            char[] chs = {'y', 'i', 'r', 'a', 'n'};
            fw.write(chs,0,chs.length);
            fw.write("小仓朝日");

            // 省略刷新 调用close()会自动调用flush()
            fw.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }

    }

}
