package com.yiran.entity.javaString;

/**
 * replace():替换字符串中的某段或某个字符
 * 可以是char 也可以是String
 *
 * isEmpty():当String为"" 空字符串时，返回true
 * */

public class StringReplace {
    public static void main(String[] args){
        String str = "aaabbbccc";
        String str2 = str.replace("aa","b");
        System.out.println(str2); // babbbccc

        String str3 = str.replace('a','哇');
        System.out.println(str3);

        String str4 = "";
        String str5 = "哇哈哈";
        boolean isEmpty1 = str4.isEmpty();
        boolean isEmpty2 = str5.isEmpty();
        System.out.println("str4 是否为空"+isEmpty1+" str5 是否为空"+isEmpty2);

    }
}
