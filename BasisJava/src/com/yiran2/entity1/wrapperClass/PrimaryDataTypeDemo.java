package com.yiran2.entity1.wrapperClass;

/**
 * 基本类型对应的包装器类
 *
 *  每一种基本数据类型都对应一种引用数据类型,如int对应Integer
 *
 *  引用类型在基本数据类型的基础上拥有更多的字段与功能
 *  如:
 *  		最大值/最小值字段：MAX_VALUE/MIN_VALUE
 *  		public static String toBinaryString(int i)  将整数转为二进制的整数字符串
 * */

public class PrimaryDataTypeDemo {
    public static void main(String[] args){
        // 定义基本类型10
        int i = 10;
        Integer i2 = new Integer(10);

        // 查看Integer可以存放的最大/最小的数
        System.out.println(i2.MAX_VALUE); // 2147483647
        System.out.println(i2.MIN_VALUE); // -2147483648

        // 将整数转为二进制字符串
        String binaryString = Integer.toBinaryString(10); // 1010
        System.out.println(binaryString);
    }
}
