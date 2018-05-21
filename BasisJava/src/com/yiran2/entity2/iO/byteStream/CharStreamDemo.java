package com.yiran2.entity2.iO.byteStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符流回顾
 *
 * 	复习应该已经具备的IO知识:
 *		向一个文件中写出字符"hello java",从一个文件中读取字符
 * */

public class CharStreamDemo {
    public static void main(String[] args){
        // 使用缓冲流写出字符
        try {
            FileWriter fw = new FileWriter("staticFile\\CharStream.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Hello MyFriend");
            bw.newLine();
            bw.write("this is newLine");
            bw.close();
        } catch (Exception e){
            System.out.println("写出路径错误");
            e.printStackTrace();
        }

        // 使用缓冲流读入字符
        try {
            FileReader fr = new FileReader("staticFile\\CharStream.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }
            br.close();
        } catch (Exception e){
            System.out.println("读入路径错误");
            e.printStackTrace();
        }
    }
}
