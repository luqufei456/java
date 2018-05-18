package com.yiran2.entity2.javaHashSet;

import java.util.HashSet;

/**
 * HashSet的练习类
 *
 *      求一个字符串"aiodjl;hriWFUADJSVUEHiowfjnivowe"中一共有几个不重复的字母,区分大小写,如a,A算两个字符
 *
 * 	分析：
 * 		将字符串拆分成一个个单个字符
 * 		判断字符是否为字母
 * 		如果是字母,放到一个HashSet集合中
 * 		查看集合长度
 * */

public class HashSetDemo2 {
    public static void main(String[] args){
        String s = "aiodjl;hriWFUADJSVUEHiowfjnivowe";

        // 定义不包含重复元素的HashSet集合 使用char的包装类泛型
        HashSet<Character> hashSet = new HashSet<Character>();

        // 将字符串转为字符数组
        char[] chs = s.toCharArray();

        // 使用增强for循环遍历字符数组
        for (char c : chs){
            // 判断是否为字母
            if ((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                // 如果是字母，放到hashSet中，因为hashSet不重复，所以全加进去，也不会有重复元素
                hashSet.add(c);
            }
        }

        // 查看集合长度
        System.out.println("在字符串中，共存在不重复的字母个数为："+hashSet.size());
    }
}
