package com.yiran2.entity2.iO.objectStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 如何循环反序列化取出对象
 * */

public class WhileObjectInputStreamDemo1 {
    public static void main(String[] args){
        String path = "staticFile\\序列化测试.txt";

        // 创建反序列化对象
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // 设置while循环默认死循环，当取不出对象时跳出循环
            // 反序列化取不出对象时会报错
            boolean judge = true;
            // 定义一个初始值统计一共有多少个序列化对象
            int num = 0;
            try {
                while (judge){
                    Object obj = ois.readObject();
                    System.out.println(obj.toString());
                    num++;
                }
            } catch ( Exception e){
                judge = false;
            }finally{
                // 关闭流
                ois.close();
            }

            // 关闭流
            //ois.close();

            System.out.println("一共有"+num+"个序列化对象");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
