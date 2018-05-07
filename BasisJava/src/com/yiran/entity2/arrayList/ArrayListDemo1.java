package com.yiran.entity2.arrayList;

import java.util.ArrayList;

/**
 *  给定一个字符串数组：{“张三丰”,“宋远桥”,“张无忌”,“殷梨亭”,“张翠山”,“莫声谷”}，
 * 将数组中的元素添加到集合中，并把所有姓张的人员打印到控制台上。
 *
 * 分析：
 * 		A:定义字符串数组
 * 		B:创建集合对象
 * 		C:遍历字符串数组，使用条件进行筛选
 * 		D:把获取到的字符串元素添加到集合
 * 		E:遍历集合
 * 			要判断每一个字符串元素是否以"陈"开头，如果是，就输出在控制台
 * */

public class ArrayListDemo1 {
    public static void main(String[] args){
        String[] strArr = {"赵天麒","杨逸晨","陈真","陈君男","韩志文","路佩琪"};

        ArrayListDemo1 arrEligible = new ArrayListDemo1();
        arrEligible.eligible(strArr,"陈");

    }

    public void eligible(String[] strArr, String conditions){
        ArrayList<String> strArr1 = new ArrayList<String>();
        for (int x = 0;x < strArr.length;x++){
            String str = strArr[x];
            if (str.startsWith(conditions)){
                strArr1.add(str);
            }
        }

        for (int i = 0;i < strArr1.size();i++){
            System.out.println(strArr1.get(i));
        }
    }

}
