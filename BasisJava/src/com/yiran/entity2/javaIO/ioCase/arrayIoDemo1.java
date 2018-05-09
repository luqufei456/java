package com.yiran.entity2.javaIO.ioCase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 把ArrayList集合中的字符串数据存储到文本文件
 *
 * 把ArrayList集合中的字符串数据存储到文本文件
 * 每一个字符串元素作为文件中的一行数据
 *
 * 分析：
 * 		A:创建集合对象
 * 		B:往集合中添加字符串元素
 * 		C:创建输出缓冲流对象
 * 		D:遍历集合，得到每一个字符串元素，然后把该字符串元素作为数据写到文本文件
 * 		E:释放资源
 * */

public class arrayIoDemo1 {
    public static void main(String[] args) throws IOException{
        // 创建字符串集合对象
        ArrayList<String> strArr = new ArrayList<String>();

        // 添加字符串元素
        strArr.add("hello~ ");
        strArr.add("chunjue");
        strArr.add(" baka");

        // 创建输出缓冲流对象
        FileWriter fw = new FileWriter("src\\com\\yiran\\entity2\\javaIO\\staticFile\\baka.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (int x = 0;x < strArr.size();x++){
            String str = strArr.get(x);
            bw.write(str);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
