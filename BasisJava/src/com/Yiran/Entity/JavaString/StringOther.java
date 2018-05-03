package com.Yiran.Entity.JavaString;

/**
 * String类的其他功能
 *
 * 去除字符串两端空格
 *		String trim()
 * 按照指定符号分割字符串
 *		String[] split(String str)
 * */

public class StringOther {
    public static void main(String[] args){
        // 创建字符串对象
        String s1 = "hellochunjue";
        String s2 = "  helloyiran  ";
        String s3 = "  hello poi  ";
        System.out.println("---"+s1+"---");
        System.out.println("---"+s1.trim()+"---");
        System.out.println("---"+s2+"---");
        System.out.println("---"+s2.trim()+"---");
        System.out.println("---"+s3+"---");
        System.out.println("---"+s3.trim()+"---");
        System.out.println("-------------------");

        // String[] split(String str)
        // 创建字符串对象 limit 可选项 限制返回数组中元素的个数
        // 比如n  那么n-1个都是单个 第n个是后面所有的当成一个字符串
        String s4 = "chunjue,yiran,miku,poi,lan";
        String[] strArray = s4.split(",");
        for (int x = 0;x < strArray.length;x++){
            System.out.println(strArray[x]);
        }

    }
}
