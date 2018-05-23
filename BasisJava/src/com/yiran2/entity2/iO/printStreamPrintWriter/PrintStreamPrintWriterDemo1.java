package com.yiran2.entity2.iO.printStreamPrintWriter;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 打印流
 *
 * 	打印流只有输出,没有输入
 * 		PrintStream字节打印流,调用println方法时自动刷新
 * 		PrintWriter字符打印流,指定自动刷新开关后,调用println方法时自动刷新,无需手动调用flush()方法
 * */

public class PrintStreamPrintWriterDemo1 {
    public static void main(String[] args){
        String path = "staticFile\\打印流测试.txt";
        /*try {
            // 创建字节打印流对象
            PrintStream ps = new PrintStream(path);
            // 输出到文本
            ps.println('a');

            // 关闭流
            ps.close();
        } catch (Exception e){
            e.printStackTrace();
        }*/

        try {
            // 创建字符打印流对象 ,如果直接创建，不刷新则无法输出
            // 通过字节输出流创建时，可以设置调用println方法时自动刷新
            FileOutputStream fos = new FileOutputStream(path);
            // 设置为false，则需要手动刷新
            PrintWriter pw = new PrintWriter(fos, true);
            // PrintWriter pw = new PrintWriter(path);
            pw.write('b');
            pw.println('c');
            pw.println(11);
            // 关闭流时会自动刷新
            pw.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
