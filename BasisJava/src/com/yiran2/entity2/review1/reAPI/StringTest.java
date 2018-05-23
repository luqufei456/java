package com.yiran2.entity2.review1.reAPI;

import java.util.Scanner;

/**
 *
 *	需求：
 *		键盘录入一个字符串，要求删除该字符串中的所有java字符串（最终的字符串中不能包含java），要求打印删除后的结果以及删除了几个java字符串
 *		比如键盘录入："java woaijava,i like jajavava,i enjoy java"
 *		程序输出结果：
 *			原字符串："java woaijava,i like jajavava,i enjoy java"中
 *			总共包含：5个java，删除java后的字符串为：" woai,i like ,i enjoy "
 *
 *====================================================================
 *	分析：
 *		1、使用键盘录入Scanner接收一个初识被判断的字符串，用变量initString接收
 *		2、定义变量，用于记录每次变化的那个字符串，即最终的字符串finalString
 *		3、定义变量，记录java的个数
 *		4、
 *			定义变量，记录java是否存在于字符串中，用索引表示(indexOf方法)
 *			while循环删除：
 *				条件：
 *					为只要字符串中没有java字符串即不再循环
 *					如果索引不为-1，就说明要删除字符串中的java；
 *					如果索引为-1，就说明已经不再包含java了，循环终止；
 *
 *				循环删除过程：
 *					由于进入了循环，所以判断字符串中有一个java，个数计数器+1
 *					将java前的字符串截取记录(substring方法(0,索引i),从0到i)
 *					将java后的字符串截取记录(substring方法(索引i+4),所i+4到最后)
 *					将java前后的字符串再拼接成新的字符串
 *					再判断新字符串中是否存在java，使用indexOf方法重新获取索引
 *
 *		5、打印结果：
 *			打印原字符串
 *			打印java个数
 *			打印不包含java的新字符串
 * */

public class StringTest {
    public static void main(String[] args){
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一串字符串：");
        // 初始化数据
        String initString = sc.nextLine();

        // 定义变量，用于记录每次变化的字符串
        String finalString = initString;

        // 定义变量，记录字符串java的个数
        int javaNumber = 0;

        // 循环，定义变量，记录java是否存在于字符串中
        int index = finalString.indexOf("java");

        // index != -1  代表还有java
        while (index != -1){
            System.out.println(index);

            try {
                // 使其每秒执行一次
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }

            // 进行删除，每次删除一个java，同时java计数器+1
            javaNumber++;

            // 将"java"前的字符串与后的字符串从原字符串分离并拼接
            String before = finalString.substring(0,index);
            String after = finalString.substring(index+4);

            finalString = before + after;

            // 再次查询是否还有"java"
            index = finalString.indexOf("java");

            // 输出删除后的字符串
            System.out.println(finalString);
        }

        // 打印结果
        System.out.println("原字符串："+initString+"中"+
                "总共包含："+javaNumber+"个java，" +
                "删除java后的字符串为："+finalString);
    }
}
