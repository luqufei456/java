package com.yiran.entity.javaString;

/**
 * 字符串反转
 *
 * 举例：键盘录入”abc”
 * 输出结果：”cba”
 *
 * 分析：
 * 		A:键盘录入一个字符串
 * 		B:写方法实现字符串的反转
 * 			a:把字符串倒着遍历，得到的每一个字符拼接成字符串。
 * 			b:把字符串转换为字符数组，然后对字符数组进行反转，最后在把字符数组转换为字符串
 * 		C:调用方法
 * 		D:输出结果
 * */

public class StringReverse {
    public static void main(String[] args){
        String str = "abcdef";
        System.out.println(reverse(str));
    }

    public static String reverse(String str){
        char[] chs = new char[str.length()];
        for (int i = str.length()-1;i >= 0;i--){ // 倒序 10-1
            chs[str.length()-1-i] = str.charAt(i); // 正序 1-10
        }
        // 可以直接用字符数据转换为字符串;
        return new String(chs);
    }
}
