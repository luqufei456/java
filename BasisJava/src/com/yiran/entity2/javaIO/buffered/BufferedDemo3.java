package com.yiran.entity2.javaIO.buffered;

import java.io.*;

/**
 * 缓冲流的特殊功能
 *
 * 缓冲流的特殊功能：
 * BufferedWriter
 * 		void newLine():写一个换行符，这个换行符由系统决定
 * BufferedReader
 * 		String readLine():一次读取一行数据，但是不读取换行符
 *      当读不到数据时，返回null
 *
 * 	windows:\r\n
 * 	linux:\n
 * 	mac:\r
 *
 */

public class BufferedDemo3 {
    public static void main(String[] args) throws IOException{
        /*// 创建输出流对象
        FileWriter fw = new FileWriter("src\\com\\yiran\\entity2\\javaIO\\staticFile\\LineDemo1.txt");
        // 创建输出缓冲流对象
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0;i < 10;i++){
            bw.write("hello");
            // 写一个换行符  替代了 bw.write("\r\n")
            bw.newLine();
            // 刷新
            bw.flush();
        }

        bw.close();
        fw.close();*/

        // 创建输入流对象
        FileReader fr = new FileReader("src\\com\\yiran\\entity2\\javaIO\\staticFile\\Buffered.txt");
        // 创建输入缓冲流对象
        BufferedReader br = new BufferedReader(fr);

        /*String line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);*/

        String line;

        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        // 缓冲流关闭会自动将 输出流、输出流对象关闭，所以不需要手动关闭
        br.close();

    }
}
