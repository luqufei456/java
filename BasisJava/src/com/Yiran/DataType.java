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
        char c1 = '啊'; // 2字节，所以能存放汉字，c语言中 char只有一个字节，所以不能存放汉字 单引号，双引号是字符串

        int a1 = 12 + c1; // 结果为109
        // char 为Unicode编码 其中每个char常量都对应了一个十进制数
        System.out.println(a1);

        // int a2 = 97;
        // char c2 = a2;  不可以

        char c2 = 'a'; // 这里就可以
        int a2 = c2; // 因为 char是 16bit 而int 是32bit 所以这是隐式转换 Unicode码里的数值是十进制数，所以可以转
        System.out.println(a2);

        //int a3 = 56;
        //short b2 = 23;
        //byte c3 = a3 + b2;
        // 看上去值没有超过127，符合 但是计算机是看大空间的int和short进入小空间byte
        // 损失了精度，所以不可以这么使用， 但是用 byte和short进入int就没问题

        double b3 = 12f + 34.23; // 从低精度到高精度会自动转换，隐式转换

        int a4 = (int)b3; // 高精度转低精度，要使用强制转换   这里的 精度 只是方便理解  实际上是范围

        int a5 = 55;
        float b4 = a5;

        // float a6 = 55.1F;
        // int b5 = a6;

        /**
         * 重点：
         * int是小数据，float是大数据，小数据到大数据转化不会报错。
         * 这里我们所说的“大”与“小”,并不是指占用字节的多少,而是指表示值的范围的大小。
         * 当一个较“小”数据与一个较“大”的数据一起运算时,系统将自动将“小”数据转换成“大”数据，
         * 由“小”到“大”分别为 (byte，short，char)--int--long--float—double。
         * */

    }
}