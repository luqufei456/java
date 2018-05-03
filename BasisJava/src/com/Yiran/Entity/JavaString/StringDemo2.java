package com.Yiran.Entity.JavaString;

/**
 * 通过构造方法创建的字符串对象和直接赋值方式创建的字符串对象有什么区别呢?
 * 		通过构造方法创建字符串对象是在堆内存。
 * 		直接赋值方式创建对象是在方法区的常量池。
 *
 * "==":
 * 		基本数据类型：比较的是基本数据类型的值是否相同
 * 		引用数据类型：比较的是引用数据类型的地址值是否相同
 * */

public class StringDemo2 {
    public static void main(String[] args){
        String str1 = new String("yiran");
        String str2 = new String("yiran");
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2); // flase 可以说明并不是同一个对象

        String str3 = "yiran";
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
        // false 1和3不是同一个对象 因为str3的字符串在常量池中 str1的字符串在堆中
        // 所以这里定义str3 不会在常量池中找到 "yiran" 所以两者的地址不同

        String str4 = "yiran";
        System.out.println(str3 == str4); // true  3和4引用的是同一个对象

    }
}
