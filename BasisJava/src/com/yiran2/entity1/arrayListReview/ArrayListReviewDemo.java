package com.yiran2.entity1.arrayListReview;

import java.util.ArrayList;

/**
 *  持有数据:
 *  		单一数据,可以定义对应类型的变量直接持有
 *  		多个数据,可以使用数组的方式记录,通过索引访问数据
 *  		又在面向对象的基础上,可以使用集合的方式记录,最开始最常用ArrayList,该集合类同样可以通过索引访问数据
 *
 *  集合的基本使用:
 *  		1创建集合对象
 *  		2向集合中添加元素
 *  		3从集合中获取元素/其他信息(集合的长度)
 * */

public class ArrayListReviewDemo {
    public static void main(String[] args){
        // 创建集合对象
        ArrayList<Integer> intList = new ArrayList<Integer>();
        // 像集合中添加元素
        intList.add(10); // 自动装箱 int -- > Integer
        intList.add(20);
        intList.add(30);

        // 从集合中获取元素/其他信息(集合的长度)
        Integer integer = intList.get(2);
        System.out.println("Integer集合中索引为2的Integer元素为："+integer);

        int size = intList.size();
        System.out.println("Integer集合的长度为："+size);
        System.out.println("--------------------------------------------");

        // 遍历集合
        for (int i = 0;i < intList.size();i++){
            // 通过索引获得集合中的每一个元素
            Integer thisInteger = intList.get(i);
            // 打印每个元素
            System.out.println(thisInteger);
        }
    }
}
