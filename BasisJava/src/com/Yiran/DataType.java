package com.Yiran;

public class DataType {
    public static void main(String[] args){
        byte a = 127; // 1字节 -128~127
        short b = 3; // 2字节
        int c = 34; // 4字节 不申明时，默认为int类型
        long d = 34L; // 后缀要加l或L
        float e = 23.34F; // 后缀没有f或F时，默认为double类型
        double f = 23.34;
        boolean s = true;
        char c1 = 'a'; // 2字节，所以能存放汉字，c语言中 char只有一个字节，所以不能存放汉字 单引号，双引号是字符串

        int a1 = 12 + c1; // 结果为109  ascii码中 a的值为97 这里能发现 char能直接参加运算
        System.out.println(a1);

        // int a2 = 97;
        // char c2 = a2;  不可以

        char c2 = 'a'; // 这里就可以
        int a2 = c2;
        System.out.println(a2);

    }
}
