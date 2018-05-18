package com.yiran2.entity2.javaHashSet;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet的测试类
 *
 *   HashSet，不包含重复元素相同元素，且无序，不提供索引，所以不能通过索引获取元素，只能通过迭代器访问数据。
 * 表面是无序的，但是实际上还是有一定排序规则。否则多次运行的结果应该不一样。
 *
 *   同样拥有 add  remove 等方法，只不过 remove方法没有重写使用索引删除元素
 * */

public class HashSetDemo1 {
    public static void main(String[] args){
        // 创建集合对象
        HashSet<String> hashSet = new HashSet<String>();
        // 像集合中添加元素
        hashSet.add("依然");
        hashSet.add("鸽l");
        hashSet.add("春雨");
        hashSet.add("诚哥");

        // 输出  可以发现 输出的顺序与添加的顺序并不一样 这是因为 HashSet是无序的,表面是无序的，但是实际上还是有一定排序规则
        System.out.println(hashSet);

        // 没有get方法，只能通过迭代器获取元素
        Iterator<String> iterator = hashSet.iterator();

        while (iterator.hasNext()){
            String thisStr = iterator.next();
            System.out.println(thisStr);
        }

        System.out.println("------------------------");
        for (String thisStr : hashSet){
            System.out.println(thisStr);
        }
    }
}
