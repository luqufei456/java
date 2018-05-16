package com.yiran2.entity1.arrayListReview;

import java.util.ArrayList;

/**
 * 使用循环删除集合中的元素时，会遇到一些问题
 * */

public class ArrayListDelete {
    public static void main(String[] args) {
        // 创建集合对象
        ArrayList<Integer> intList = new ArrayList<Integer>();

        // 像集合中添加元素
        intList.add(10);
        intList.add(20);
        intList.add(20);
        intList.add(30);

        ArrayList<Integer> intList2 = new ArrayList<Integer>(intList);

        System.out.println("intList:"+intList);
        System.out.println("intList2:"+intList2);

        /*for (int i = 0;i < intList.size();i++){
            if (intList.get(i) == 20){
                intList.remove(intList.get(i));
            }
        }*/

        // 使用 另一个完全一样的集合来当模板，就不会存在因为删除了前面的元素，后面的元素递进，从而漏删的情况
        for (int i = 0; i < intList2.size(); i++) {
            if (intList2.get(i) == 20) {
                intList.remove(intList2.get(i));
            }
        }

        System.out.println("删除后intList:"+intList);
        
    }
}
