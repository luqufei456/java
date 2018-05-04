package com.yiran.entity.javaString;

/**
 * String类的转换功能：
 * 	char[] toCharArray():把字符串转换为字符数组
 * 	String toLowerCase():把字符串转换为小写字符串
 * 	String toUpperCase():把字符串转换为大写字符串
 *
 * 字符串的遍历：
 * 		A:length()加上charAt()
 * 		B:把字符串转换为字符数组，然后遍历数组
 * */

public class StringConversion1 {
    public static void main(String[] args){
        // 创建字符串对象
        String str = "Hello Yiran";

        // char[] toCharArray():把字符串转换为字符数组
        char[] chs = str.toCharArray();

        for (int i = 0;i < chs.length;i++){
            System.out.print(chs[i]+ " ");
        }
        System.out.println("----这是一条正义的分割线----");

        System.out.println("String toLowerCase():把字符串转换为小写字符串");
        System.out.println("Hello Yiran".toLowerCase());
        System.out.println("String toUpperCase():把字符串转换为大写字符串");
        System.out.println("Hello Yiran".toUpperCase());

    }
}
