package com.yiran2.entity2.iO.bufferedCharacterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 高效字符输出流的特殊方法
 *
 *  换行时,每种环境对换行的识别不同.windows识别\r\n,有的识别\r有的识别\n
 *
 *  BufferedWriter特殊方法:
 *  		public void newLine() 根据不同的环境生成不同的换行标记
 *
 *
 *  BufferedReader特殊方法:
 *  		public String readLine() 读取数据,一次读取一行,读到末尾返回null,不会读取任何终止符
 *  	例如\n 这样的换行符
 * */

public class BufferedWriterReaderDemo2 {
    public static void main(String[] args){
        String path = "staticFile\\WriterTest2.txt";

        try {
            // 创建普通输出流对象
            FileWriter fw = new FileWriter(path);
            // 创建缓冲输出流对象
            BufferedWriter bw = new BufferedWriter(fw);
            // 写三行
            for (int i = 0;i < 3;i++){
                bw.write("我卢本伟，没有开挂！");
                // 这样就会换行了，而不是同一行追加。
                bw.newLine();
            }
            // 关闭缓冲流
            bw.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }

        try {
            // 创建普通读入流对象
            FileReader fr = new FileReader(path);
            // 创建缓冲读入流对象
            BufferedReader br = new BufferedReader(fr);
            // 使用readLine读入，返回是一个字符串,读完时返回null
            // 不会读取换行符，不然我们试一下使用print 而不是println
            String read;
            while ((read = br.readLine()) != null){
                // 可以看到，不使用println会在同一行输出
                // System.out.print(read);
                System.out.println(read);
            }

            // 关闭缓冲流，会自动先关闭普通流
            br.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }
    }
}
