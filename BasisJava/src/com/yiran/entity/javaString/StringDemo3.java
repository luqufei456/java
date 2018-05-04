package com.yiran.entity.javaString;

/**
 * 统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。
 *
 * 分析：
 * 		A:键盘录入一个字符串数据
 * 		B:定义三个统计变量，初始化值都是0
 * 		C:遍历字符串，得到每一个字符
 * 		D:拿字符进行判断
 * 			假如ch是一个字符。
 * 			大写：ch>='A' && ch<='Z'
 * 			小写：ch>='a' && ch<='z'
 * 			数字：ch>='0' && ch<='9'
 * 		E:输出结果
 * */

import java.util.Scanner;

public class StringDemo3 {
    public static void main(String[] args){
        // 键盘录入一个字符串数据
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个字符串数据：");
        String str = sc.nextLine();

        // 定义三个变量统计出现次数
        int bigCount = 0;
        int smallCount = 0;
        int numberCount = 0;

        for (int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            // 将遍历出来的 char进行比较
            if (ch>='A' && ch<='Z'){
                bigCount++;
            }
            else if (ch>='a' && ch<='z'){
                smallCount++;
            }
            else if (ch>='0' && ch<='9'){
                numberCount++;
            }
            else{
                System.out.println("字符"+ch+"无法正常统计");
            }
        }

        System.out.println("大写字符 "+ bigCount + " 个");
        System.out.println("小写字符 "+ smallCount + " 个");
        System.out.println("数字字符 "+ numberCount + " 个");

    }
}
