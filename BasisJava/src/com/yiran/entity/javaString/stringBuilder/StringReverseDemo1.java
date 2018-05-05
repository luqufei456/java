package com.yiran.entity.javaString.stringBuilder;

/**
 * 需求：利用StringBuilder完成字符串反转
 *
 * 分析：
 * 		A:键盘录入一个字符串
 * 		B:写方法实现反转
 * 			String --> StringBuilder --> reverse() --> String
 * 		C:调用方法
 * 		D:输出结果
 * */

import java.util.Scanner;

public class StringReverseDemo1 {

    public static void main(String[] args){
        // 构造Scanner对象
        Scanner sc = new Scanner(System.in);

        // 获取字符串
        System.out.print("请输入一串字符：");
        String str = sc.nextLine();

        // 注意，这里都是新的字符串了，并不是在原来的字符串上进行操作，所以内存地址什么都不一样，不要搞混
        String str1 = strReverse(str);
        System.out.println(str1);
    }

    public static String strReverse(String str){
        // 转换为StringBuilder
        StringBuilder strB = new StringBuilder(str);
        // 反转字符串
        strB.reverse();
        // 转回String类型
        return strB.toString();
    }

}
