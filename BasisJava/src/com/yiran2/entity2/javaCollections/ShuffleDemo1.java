package com.yiran2.entity2.javaCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collections的shuffle方法
 *
 *  Collections:集合工具类,包含了众多集合的方法
 *
 *  public static void shuffle(List<?> list)				//打乱元素顺序
 *
 *      有顺序(有序):第一个元素是多少,第二个元素是多少,第几个元素对应的是第几,顺序不变.
 * */

public class ShuffleDemo1 {
    public static void main(String[] args){
        // 准备集合元素
        Collection<Integer> clist = new ArrayList<Integer>();

        // 一次性加入多个元素
        Collections.addAll(clist,10,20,30,40,50);
        // 先输出，查看其顺序,现在的顺序就是添加的顺序
        System.out.println("打乱前的Integer集合："+clist);

        // 打乱其顺序 shuffle方法的参数类型为List，所以这里强转为List类型
        Collections.shuffle((List)clist);
        // 输出，查看打乱后的顺序
        System.out.println("打乱后的Integer集合："+clist);
    }
}
