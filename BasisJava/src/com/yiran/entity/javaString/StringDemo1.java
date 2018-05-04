package com.yiran.entity.javaString;

/**
 * String:字符串类
 * 		由多个字符组成的一串数据
 * 		字符串其本质是一个字符数组
 *
 * 构造方法：
 * 		String(String original):把字符串数据封装成字符串对象
 * 		String(char[] value):把字符数组的数据封装成字符串对象
 * 		String(char[] value, int offset, int count):把字符数组中的一部分数据封装成字符串对象
 *
 * 注意：字符串是一种比较特殊的引用数据类型，直接输出字符串对象输出的是该对象中的数据。
 * */

public class StringDemo1 {
    public static void main(String[] args){
        // 方式1
        // String(String original)将字符串数据封装成字符串对象
        String s1 = new String("hello");
        System.out.println("s1:"+s1);
        System.out.println("---------");

        // 方式2
        // String(char[] value)将字符数组的数据封装成字符串对象
        char[] chs = {'y','i','r','a','n'};
        String s2 = new String(chs);
        System.out.println("s2:"+s2);
        System.out.println("---------");

        // 方式3
        // String(char[] value, int offset, int count)将字符数组中的一部分数据封装成字符串对象
        // offset 起始点  count 取char的个数
        System.out.println(chs.length);
        String s3 = new String(chs,0,3);
        //从什么地方开始 取几个char当字符串 并不是取到下标为count的地方，而是取count个char
        System.out.println("s3:"+s3);
        System.out.println("---------");

        //方式4 一般方式
        String s4 = "hello yiran";
        System.out.println("s4:"+s4);

    }
}
