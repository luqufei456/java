package com.yiran.entity.javaString;

import java.util.Scanner;

/**
 * 键盘录入一个字符串，把该字符串的首字母转成大写，其余为小写。(只考虑英文大小写字母字符)
 * 分析：
 * 		A:键盘录入一个字符串
 * 		B:截取首字母
 * 		C:截取除了首字母以外的字符串
 * 		D:B转大写+C转小写
 * 		E:输出即可
 * */

public class StringConversion2 {
    public static void main(String[] args){
        // 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String str = sc.nextLine();

        // 截取首字母
        String s1 = str.substring(0,1);

        // 截取除了首字母以外的字符串
        String s2 = str.substring(1);

        // s1转大写+ s2转小写
        String s3 = s1.toUpperCase()+s2.toLowerCase();

        // 输出
        System.out.println(s3);

    }
}
