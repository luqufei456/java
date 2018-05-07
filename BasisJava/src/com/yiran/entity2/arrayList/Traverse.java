package com.yiran.entity2.arrayList;

import java.util.ArrayList;

/**
 * 集合的遍历思想和数组的遍历思想相同
 * 循环遍历容器,依次取出里面的元素即可
 *
 * ArrayList集合的遍历
 * 		通过size()和get()配合实现的
 * */

public class Traverse {
    public static void main(String[] args){
        ArrayList<String> strArr = new ArrayList<String>();
        strArr.add("依然");
        strArr.add("太太");
        strArr.add("真红");
        strArr.add("诚哥");

        Traverse traverse = new Traverse();
        traverse.traverse(strArr);

    }

    public void traverse(ArrayList arr){
        for (int x = 0;x < arr.size();x++){
            System.out.println(arr.get(x));
        }
    }

}
