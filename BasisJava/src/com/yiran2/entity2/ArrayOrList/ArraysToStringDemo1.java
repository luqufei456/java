package com.yiran2.entity2.ArrayOrList;

import java.util.Arrays;

/**
 * Arrays工具类的toString方法
 *
 *  Arrays:
 * 	数组工具类,包含了许多数组工具方法
 *
 * 	public static int binarySearch(Xxx[] a,Xxx key)	//查找元素索引
 * 	public static void sort(Xxx[] a)				//排序
 * 	public static String toString(Xxx[] a)			//返回字符串内容
 * */

public class ArraysToStringDemo1 {
    public static void main(String[] args){
        String[] strArr = {"yiran", "miku", "poi", "chunjue"};
        // 数组为引用类型，内置方法并不支持直接输出
        System.out.println("直接输出数组："+strArr);

        // 调用Arrays的toString方法
        String str = Arrays.toString(strArr);
        System.out.println("输出转为字符串的数组："+str);
    }
}
