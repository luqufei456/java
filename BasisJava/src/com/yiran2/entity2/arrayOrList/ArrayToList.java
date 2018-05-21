package com.yiran2.entity2.arrayOrList;

import java.util.Arrays;
import java.util.List;

/**
 * 数组转集合--其实是实现了Arrays中的一个内部静态类ArrayList，并不是真正的ArrayList，并没有实现增删方法
 *
 *  Arrays:
 * 	public static <T> List<T> asList(T... a)				//数组转集合
 *
 * 	UnsupportedOperationException:不支持的添加或者删除操作
 * */

public class ArrayToList {
    public static void main(String[] args){
        String[] strArr = {"yiran", "chunjue", "baka"};
        List<String> list = Arrays.asList(strArr);
        System.out.println("转为内部类集合后可以直接输出："+list);

        // 其实是实现了Arrays中的一个内部静态类ArrayList，并不是真正的ArrayList，并没有实现增删方法
        try {
            list.add("不能添加");
        } catch (Exception e){
            System.out.println("都说了不能添加元素了~其实是实现了Arrays中的一个内部静态类ArrayList，并不是真正的ArrayList，并没有实现增删方法");
            e.printStackTrace();
        }
    }
}
