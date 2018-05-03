package com.Yiran.Entity.JavaString;

/**
 * String类的获取功能：
 * 	int length():获取字符串的长度，其实也就是字符个数
 * 	char charAt(int index):获取指定索引处的字符
 * 	int indexOf(String str):获取str在字符串对象中第一次出现的索引 也可以是 char 类型 也可以设置起始点 这样可以查在后面出现的
 * 	String substring(int start):从start开始截取字符串
 * 	String substring(int start,int end):从start开始，到end结束截取字符串。包括start，不包括end
 * */

public class StringGet {

    public static void main(String[] args){
        // 创建字符串对象
        String str = "Hello Chunjue Chunjue";

        System.out.println("int length():获取字符串的长度，其实也就是字符个数");
        System.out.println(str.length());

        System.out.println("char charAt(int index):获取指定索引处的字符");
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(6));

        System.out.println("int indexOf(String str):获取str或char在字符串对象中第一次出现的索引");
        System.out.println(str.indexOf('H'));
        System.out.println(str.indexOf("Chunjue"));
        System.out.println(str.indexOf("Chunjue",14));

        System.out.println("String substring(int start):从start开始截取字符串");
        System.out.println(str.substring(5));
        System.out.println(str.substring(6,13)); // 不取endindex 所以这里13

    }

}
