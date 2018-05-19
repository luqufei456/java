package com.yiran2.entity2.javaCollections;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collections的binarySearch方法 即为，二分查找
 *
 *  public static <T> int binarySearch(List<?>list,T key)	//查找元素索引
 *  二分法查找:在一个集合当中,查找一个指定元素的索引是多少,如果不存在该元素,就返回负数索引
 *  二分法查询必须要求集合中的元素排好顺序
 *
 *  public static void shuffle(List<?> list)				//打乱元素顺序
 *
 *  有顺序(有序):第一个元素是多少,第二个元素是多少,第几个元素对应的是第几,顺序不变.
 * */

public class BinarySearchDemo1 {
    public static void main(String[] args){
        // 验证二分查找法，元素必须有序
        Collection<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 20, 10, 60, 40, 30, 50);

        // 使用二分查找 ，查找无序的集合 发现有问题，甚至出现索引-3
        List<Integer> intlist1 = (List<Integer>) intList;
        System.out.println("list排序前："+intlist1);
        int bianryIndex1 = Collections.binarySearch(intlist1, 10);
        System.out.println("无序时10的索引为："+bianryIndex1);
        int bianryIndex2 = Collections.binarySearch(intlist1, 50);
        System.out.println("无序时50的索引为："+bianryIndex2);

        // 进行排序，之后再次进行二分查找
        Collections.sort(intlist1);
        System.out.println("list排序后："+intlist1);
        int bianryIndex3 = Collections.binarySearch(intlist1, 10);
        System.out.println("有序时10的索引为："+bianryIndex3);
        int bianryIndex4 = Collections.binarySearch(intlist1, 50);
        System.out.println("有序时50的索引为："+bianryIndex4);
    }
}
