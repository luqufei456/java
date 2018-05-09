package com.yiran.entity2.javaIO.useMethods;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件复制拷贝 直接使用int read()
 *
 * 需求：
 * 		把项目路径下的FileWriterDemo.java中的内容复制到项目路径下的Copy.java中
 *
 * 文件复制也是有规律可循的，也就是说有套路。
 *
 * 数据源：
 * 		FileWriterDemo.java -- 读数据 -- FileReader
 * 目的地：
 * 		Copy.java -- 写数据 -- FileWriter
 * */

public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        // 创建输入流对象
        FileReader fr = new FileReader("src\\com\\yiran\\entity2\\javaIO\\fileWriter\\FileWriterDemo1.java");

        // 创建输出流对象
        FileWriter fw = new FileWriter("src\\com\\yiran\\entity2\\javaIO\\staticFile\\copy2.txt");

        int ch;

        while ((ch = fr.read()) != -1){
            // 可以看到，这里ch为int类型，但是最后的文件中，一样是各种字符等
            // 这是因为write方法会以Ascii码输出，并不会输出数字
            fw.write(ch);
            System.out.println(ch);
        }

        // 先打开的后关闭，后打开的先关闭
        fw.close();
        fr.close();

    }
}
