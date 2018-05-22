package com.yiran2.entity2.iO.objectStream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 对象的序列化操作
 *
 * 序列化流可以用来将一个对象整体转为二进制数并存储到文件中。
 * 将对象永久性存入一个文件中，叫做序列化，读取叫做反序列化。
 *
 * 每个被序列化操作的类型必须实现Serializable接口(具备序列化功能的标记接口),让其具备序列化能力
 *
 * ObjectOutputStream序列化流
 * 		public final void writeObject(Object obj)
 * ObjectInputStream反序列化流
 * 		public final Object readObject()
 * */

public class ObjectOutputStreamDemo1 {
    public static void main(String[] args){
        String path = "staticFile\\序列化测试.txt";
        // 准备被序列化的对象
        PersonStream yiran = new PersonStream("依然",21);

        // 创建序列化流对象
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // 序列化对象 这时，打开文件会发现，写入的变成乱码，这是因为
            // 是序列化和反序列化都是基于二进制流的，转成ascii就成了乱码。
            // 属于正常情况，用于给程序读取，而不是给人读取的。
            oos.writeObject(yiran);
            // 关闭流
            oos.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }
    }
}
