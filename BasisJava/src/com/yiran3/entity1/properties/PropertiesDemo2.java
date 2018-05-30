package com.yiran3.entity1.properties;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

/**
 * 将集合中内容存储到文件
 *      store(OutputStream,comments)
 *      store(Writer,comments);
 *      把集合中的数据，保存到指定的流所对应的文件中，参数comments代表对描述信息
 *
 * Properties 对应一种特殊文件：*.properties
 * 一行表示一个键值对，格式：k=v
 * */

public class PropertiesDemo2 {
    @Test
    public void test01(){
        try {
            // 1.创建对象
            Properties props = new Properties();

            // 2.设置数据
            props.setProperty("name", "依然");
            props.setProperty("age","21");
            props.setProperty("study", "java");

            // 3.将props写入到硬盘,这里用了一个转换流
            String path = "staticFile\\Test01.properties";
            FileOutputStream fos = new FileOutputStream(path);
            Writer writer = new OutputStreamWriter(fos, "utf-8");

            // 写入 这里的描述会变成\u8FD9\u662F\u4E00\u4E2A\u63CF\u8FF0~
            // 但是props的属性名和属性值不会变 还是中文
            props.store(writer,"这是一个描述~");
            // 关闭流
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
