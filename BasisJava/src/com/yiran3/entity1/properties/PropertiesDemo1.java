package com.yiran3.entity1.properties;

import org.junit.Test;

import java.util.Properties;
import java.util.Set;

/**
 * Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
 * 特点：
 *      1、Map接口的子类，map中的方法都可以用。
 *      2、该集合没有泛型。键值都是字符串。
 *      3、它是一个可以持久化的属性集。键值可以存储到集合中，
 *   也可以存储到持久化的设备(硬盘、U盘、光盘)上。键值的来源也可以是持久化的设备。
 *      4、有和流技术相结合的方法。
 *
 * 常用方法：
 *      public Object setProperty(String key, String value)调用 Map 的方法 put。
 *      public Set<String> stringPropertyNames()返回此属性列表中的键集，
 *      public String getProperty(String key)用指定的键在此属性列表中搜索属性
 * */

public class PropertiesDemo1 {
    @Test
    public void test01(){
        // 1.Properties对象 特殊Map<String,String>
        // Properties对象没有泛型，默认为<String, String>
        Properties props = new Properties();

        // 2.设置数据
        // props.put("aa","bb"); 使用put可以插入不是String类型的
        // 但是不建议，因为这个是要保存在流中的。
        props.setProperty("k01", "v01");
        props.setProperty("k02", "v02");
        props.setProperty("k03", "v03");

        // 3.获得指定名称的数据
        // props.get("k01") 返回的是个obj类型
        Object obj = props.get("k01");
        System.out.println("props.get(\"k01\")："+obj);
        String v01 = props.getProperty("k01");
        System.out.println("props.getProperty(\"k01\")："+v01);

        // 4.获得所有key，并遍历获得所有value
        // map共用方法
        Set keys = props.keySet();
        for (Object thisKey : keys){
            Object thisValue = props.get(thisKey);
            System.out.println(thisKey+"："+thisValue);
        }
        System.out.println("-------------------------");
        // properties特有方法，获取所有的字符串属性名 -- key
        Set<String> names = props.stringPropertyNames();
        for (String thisname : names){
            String thisvalue = props.getProperty(thisname);
            System.out.println(thisname+"："+thisvalue);
        }
    }
}
