package com.yiran2.entity2.iO.bufferedCharacterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 将文件Student.txt中所有名称读取,并倒序再输入进Student.txt中
 *
 * 	将文件Student.txt中所有名称读取,并倒序再输入进Student.txt中
 *
 * 	1.定义集合ArrayList<String>存储姓名
 * 	2.使用高效流对象,一次读取一行(每次读取一个姓名)
 * 	3.将读取到的姓名放到集合中
 * 	4.Collections的reverse方法反转集合内容
 * 	5.使用高效流,一次写出一个姓名
 * */

public class BufferedWriterReaderTest {
    static ArrayList<String> names = new ArrayList<String>();

    public static void main(String[] args){
        String path = "staticFile\\Student.txt";
        BufferedWriterReaderTest admin = new BufferedWriterReaderTest();
        admin.getNames(path);
        admin.setNames(path);
    }

    public void getNames(String path){
        // 每次读取前先清空集合
        names.clear();
        try {
            // 创建缓冲流对象
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            // 使用readLine读取每名学生的姓名，存入静态集合中
            String name;
            while ((name = br.readLine()) != null){
                // System.out.println(name);
                names.add(name);
            }

            // 关闭流
            br.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }
    }

    public void setNames(String path){
        try {
            // 创建缓冲流对象
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);

            // 使用reverse方法将集合倒序
            Collections.reverse(names);

            // 使用增强for循环写入名字，并使用newLine方法
            for (String name : names){
                bw.write(name);
                bw.newLine();
            }

            // 关闭流
            bw.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }
    }
}
