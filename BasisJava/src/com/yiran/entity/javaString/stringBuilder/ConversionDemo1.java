package com.yiran.entity.javaString.stringBuilder;

/**
 * 需求：StringBuilder和String通过方法互相转换
 *
 * StringBuilder --> String
 * 		public String toString():通过toString()就可以实现把StringBuilder转成String
 *
 * String --> StringBuilder
 * 		StringBuilder(String str):通过构造方法就可以实现把String转成StringBuilder
 * */

public class ConversionDemo1 {
    public static void main(String[] args){
        // StringBuilder --> String
        StringBuilder yiran = new StringBuilder("miao~");
        yiran.append(" 呀吼");
        //  不能直接这样转换 这里可以看出来 yiran 并不算一个直接的字符串类型 虽然输出出去和字符串没有区别
        // String yiran1 = yiran;
        // 通过 toString() 方法进行转换
        String yiran1 = yiran.toString();
        System.out.println("yiran:"+yiran);
        System.out.println("yiran1:"+yiran1);
        System.out.println();

        // 不是一个类型，无法用 == 来比较
        // System.out.println(yiran1 == yiran);
        System.out.println(yiran1.equals(yiran)); // false 不是同一类型，所以直接返回false
        System.out.println();

        // String --> StringBuilder
        String chunjue = "baka";
        StringBuilder chunjue1 = new StringBuilder(chunjue);
        System.out.println("chunjue:"+chunjue);
        System.out.println("chunjue1::"+chunjue1);

    }
}
