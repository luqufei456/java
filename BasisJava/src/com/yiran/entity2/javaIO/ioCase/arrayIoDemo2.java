package com.yiran.entity2.javaIO.ioCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class arrayIoDemo2 {
    public static void main(String[] args) throws IOException{
        // 创建字符串集合对象
        ArrayList<String> strArr = new ArrayList<String>();

        // 创建输入缓冲流对象
        FileReader fr = new FileReader("src\\com\\yiran\\entity2\\javaIO\\staticFile\\baka.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null){
            strArr.add(line);
        }

        br.close();
        System.out.println(strArr);
    }
}
