package com.yiran2.entity1.apiDemo;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * 日期类的测试类
 *
 *   API:application programming interface
 *  		应用程序变成时用到的接口
 *  		应用程序编程接口
 *  		白话:java提供的类或者接口
 *
 *  日期:Date类是操作最简单的日期类，代表一个瞬间。
 *  以毫秒作为标记,即距离1970年1月1日00:00:00所经过的毫秒值,再通过毫秒值计算出对应的年、月、日、时、分、秒、星期等时间信息
 *
 *  构造方法：
 *  		public Date()			//返回当前时间
 *  		public Date(long date)	//返回指定毫秒值的日期对象
 *  普通方法:
 *  		public long getTime()   //获取当前时间对象的毫秒值
 *  		public void setTime(long time)  //设置时间毫秒值
 * */

public class DateDemo {
    public static void main(String[] args){
        // 创建当前时间的Date对象
        Date date = new Date(); // Tue May 15 19:36:36 CST 2018
        System.out.println(date);

        long time = date.getTime(); // 1526384196777
        System.out.println(time);

        // 制定毫秒值创建Date对象
        Date date2 = new Date(0L); // Thu Jan 01 08:00:00 CST 1970
        System.out.println(date2);

        // 修改日期毫秒值
        date2.setTime(1976967579L); // Sat Jan 24 05:09:27 CST 1970
        System.out.println(date2);
    }
}
