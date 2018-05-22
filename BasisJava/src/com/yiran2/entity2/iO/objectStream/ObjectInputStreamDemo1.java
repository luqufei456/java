package com.yiran2.entity2.iO.objectStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 对象的反序列化操作
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

public class ObjectInputStreamDemo1 {
    public static void main(String[] args){
        String path = "staticFile\\序列化测试.txt";

        // 创建反序列化流对象
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // 反序列化流对象可以读取对象，我们看文件的时候看到的是乱码
            // 然而对反序列化流对象的读取却不会产生影响
            // 反序列化
            /**
             *      当我们一个实体类中没有显示的定义一个名为“serialVersionUID”、
             *  类型为long的变量时，Java序列化机制会根据编译时的class自动
             *  生成一个serialVersionUID作为序列化版本比较，这种情况下，
             *  只有同一次编译生成的class才会生成相同的serialVersionUID。
             *  譬如，当我们编写一个类时，随着时间的推移，我们因为需求改动，
             *  需要在本地类中添加其他的字段，这个时候再反序列化时便会
             *  出现serialVersionUID不一致，导致反序列化失败。那么如何解决呢？
             *  便是在本地类中添加一个“serialVersionUID”变量，值保持不变，
             *  便可以进行序列化和反序列化。
             *
             *      在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与
             *  本地实体类中的serialVersionUID进行比较，如果相同则认为是一致的，
             *  便可以进行反序列化，否则就会报序列化版本不一致的异常。
             * */

            // 这里，我向PersonStream中又重写了一次toString方法，
            // 报错， serialVersionUID 不匹配
            // 解决方法：
            PersonStream yiran = (PersonStream)ois.readObject();
            System.out.print("yiran的name为："+yiran.getName());
            System.out.println(" ，age为："+yiran.getAge());
            System.out.println("直接输出对象，查看地址："+yiran);
            System.out.println("调用重写的toString方法："+yiran.toString());
            // 关闭流
            ois.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }
    }
}
