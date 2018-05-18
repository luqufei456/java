package com.yiran2.entity1.javaIterator.forUp;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 增强for循环
 *
 *  foreach循环(又叫增强for循环)来完成容器中元素的获取
 *
 *  增强for循环用来迭代集合或数组，格式如下：
 *  		for(容器内类型临时变量：容器) {
 *  			内部可以直接使用临时变量访问数据
 *  		}
 *
 *  增强for循环源代码底层就是迭代器.所以不能在增强for循环的过程当中为集合添加或者删除元素.因为会产生并发修改异常.
 *  所以,增强for循环只用来查看数据,不作数据增加或修改.
 *
 *    1、对于数组，foreach 循环实际上还是用的普通的 for 循环
 *
 *    2、对于集合，foreach 循环实际上是用的 iterator 迭代器迭代
 * */

public class ForUp {
    public static void main(String[] args){
        // 创建集合对象
        ArrayList<Integer> intList = new ArrayList<Integer>();

        // 像集合中添加元素
        intList.add(10);
        intList.add(20);
        intList.add(30);

        // 使用增强for循环迭代集合
        for (Integer thisInteger : intList){
            System.out.println(thisInteger);
        }

        System.out.println("------------------------------------");

        // 增强for循环迭代String数组
        String[] strArr = {"依然", "poi", "miku", "蠢觉", "岚"};
        for (String thisString : strArr){
            System.out.println(thisString);
        }
    }
}
