package com.yiran.entity.javaString.stringBuilder;

/**
 * 需求：判断字符串是否对称
 *
 * 例如"abc"不是对称字符串，"aba"、"abba"、"aaa"、"mnanm"是对称字符串
 *
 * 分析：
 * 		A:键盘录入一个字符串
 * 		B:写方法实现判断一个字符串是否是对称字符串
 * 			把字符串反转，和反转前的字符串进行比较，如果内容相同，就说明是对称字符串
 * 		C:调用方法
 * 		D:输出结果
 * */

import java.util.Scanner;

public class JudgeSymmetryDemo1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一串字符串：");
        String str = sc.nextLine();

        boolean isSymmetry = isSymmetry(str);

        System.out.println("是否为对称字符串："+isSymmetry);

    }

    public static boolean isSymmetry(String str){
        // String --> StringBuilder
        StringBuilder strB = new StringBuilder(str);

        // 反转再转换为字符串
        strB.reverse();
        String str1 = strB.toString();

        // 查看反转后内容是否相同，相同则为对称
        return str.equals(str1);
    }
}
