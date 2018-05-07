package com.yiran.entity2.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 获取元素
 * 		public E get(int index):返回指定索引处的元素
 * 集合长度
 * 		public int size():返回集合中的元素的个数
 * 删除元素
 * 		public boolean remove(Object o):删除指定的元素，返回删除是否成功
 * 		public E remove(int index):删除指定索引处的元素，返回被删除的元素
 * 修改元素
 * 		public E set(int index,E element):修改指定索引处的元素，返回被修改的元素
 *
 * 	还有很多方法，例如：
 * 	    indexOf()、clear()、replaceAll()、sort()等等，详细查看api文档
 * */

public class ArrayListDelChangeGet {
    public static void main(String[] args){
        ArrayList<String> strArr = new ArrayList<String>();

        // 添加元素
        strArr.add("yiran");
        strArr.add("chunjue");
        strArr.add("baba");
        strArr.add("miku");

        // public E get(int index):返回指定索引处的元素
        System.out.println(strArr.get(0));
        // public int size():返回集合中的元素的个数 类似于length方法
        System.out.println(strArr.get(strArr.size()-1));
        System.out.println();
        System.out.println("集合中一共有"+strArr.size()+"个元素");

        // public boolean remove(Object o):删除指定的元素，返回删除是否成功
        strArr.add("被删除元素a");
        strArr.add(0,"被删除元素b");
        System.out.println("使用指定删除："+strArr.remove("被删除元素a"));

        // public E remove(int index):删除指定索引处的元素，返回被删除的元素
        System.out.println("使用索引删除："+strArr.remove(0));

        // public E set(int index,E element):修改指定索引处的元素，返回被修改的元素
        System.out.println("修改元素："+strArr.set(0,"依然超厉害"));

        // 输出
        System.out.println("排序后："+strArr);
        // 排序，一般是升序
        Collections.sort(strArr);
        System.out.println("排序前："+strArr);


    }

}
