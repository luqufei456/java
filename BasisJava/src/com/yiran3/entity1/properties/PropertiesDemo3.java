package com.yiran3.entity1.properties;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
import java.util.Set;

/**
 * 读取文件中的数据，并保存到集合
 *      load(InputStream)
 *      load(Reader)
 *      把指定流所对应的文件中的数据，读取出来，保存到Properties集合中
 * */

public class PropertiesDemo3 {
    @Test
    public void Test01(){
        try {
            // 1.获得资源流 这里也是用了转换流
            String path = "staticFile\\Test01.properties";
            FileInputStream fis = new FileInputStream(path);
            Reader reader = new InputStreamReader(fis,"utf-8");

            // 2.通过properties加载对象流
            Properties props = new Properties();
            props.load(reader);

            // 3.遍历取值
            Set<String> names = props.stringPropertyNames();
            for (String thisName : names){
                String thisValue = props.getProperty(thisName);
                System.out.println(thisName+"@"+thisValue);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
