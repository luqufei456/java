package com.yiran2.entity2.javaMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * LinkedHashMap的使用
 *
 * 	LinkedHashMap:
 * 	    是HashMap的子类
 * 		Linked链表结构,保证元素有顺序
 * 		Hash结构保证元素唯一
 * 		以上约束对键起作用
 * 	差不多就相当于多了一个有序
 * */

public class LinkedHashMapDemo1 {
    public static void main(String[] args){
        // 创建集合对象
        LinkedHashMap<String, String> yiran = new LinkedHashMap<String, String>();

        // 向集合中添加数据
        yiran.put("姓名", "依然");
        yiran.put("年龄", "21");
        yiran.put("身高", "177cm");
        yiran.put("体重", "54kg");

        // 观察有序字典 即map  发现和添加的顺序相同
        System.out.println(yiran);

        LinkedHashMapDemo1 admin = new LinkedHashMapDemo1();
        admin.traverse(yiran);
    }

    public void traverse(LinkedHashMap linkedHashMap){
        // 先获得其键的set集合，利用set集合来获得值
        Set keySet = linkedHashMap.keySet();

        // 使用增强for循环获得Key值，再得到Value输出
        for (Object thisKey : keySet){
            Object thisValue = linkedHashMap.get(thisKey);
            System.out.println("Key:Value = "+thisKey+":"+thisValue);
        }
    }
}
