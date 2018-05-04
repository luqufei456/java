package com.yiran.entity.javaString;

/**
 * Object:是类层次结构中的根类，所有的类都直接或者间接的继承自该类。
 *  如果一个方法的形式参数是Object，那么这里我们就可以传递它的任意的子类对象。
 *
 * String类的判断功能：
 * 	boolean equals(Object obj):比较字符串的内容是否相同
 * 	boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写
 * 	boolean startsWith(String str):判断字符串对象是否以指定的str开头
 * 	boolean endsWith(String str):判断字符串对象是否以指定的str结尾
 * */

public class StringJudgement {
    public static void main(String[] args) {
        // 创建字符串对象
        String s1 = "yiran";
        String s2 = "yiran";
        String s3 = "Yiran";

        System.out.println("boolean equals(Object obj):比较字符串的内容是否相同");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));

        System.out.println("boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写");
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.equalsIgnoreCase(s3));

        System.out.println("boolean startsWith(String str):判断字符串对象是否以指定的str开头");
        System.out.println(s1.startsWith("yi"));
        // 从下标为2的地方开始，看是否为 ran开始
        System.out.println(s1.startsWith("ran",2));

    }
}
