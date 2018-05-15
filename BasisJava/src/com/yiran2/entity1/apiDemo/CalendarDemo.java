package com.yiran2.entity1.apiDemo;

import java.util.Calendar;
import java.util.Date;

/**
 * 日历的属性
 *
 *  	Date类的大批方法(尤其是获取各种时间属性值得方法)都过期,被Calendar类替代了.
 *
 *  	Calendar:日历类,将各种时间的属性信息以字段的方式记录下来
 *
 *  	创建Calendar对象,不使用构造方法,使用一下方法,支持语言敏感的问题,静态方法getInstance,获取当前时间
 *  	Calendar rightNow = Calendar.getInstance();
 *
 *  	获取时间属性的方法:
 *  		public int get(int field)	//获取时间字段值，字段参见帮助文档int field对应的字段
 *  		public final void set(int year,int month,int date)	//设置年月日，可查看对应重载
 *  		public final Date getTime()	//获取该日历对象转成的日期对象
 * */

public class CalendarDemo {
    public static void main(String[] args){
        // 创建日历类对象，当前时间
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        // Calendar转成Date对象
        Date time = calendar.getTime();
        System.out.println(time);

        // 获取属性值
        int year = calendar.get(calendar.YEAR);
        System.out.println(year);

        int month = calendar.get(calendar.MONTH);
        System.out.println(month+1); // 这里是从0开始 所以+1

        int day = calendar.get(calendar.DAY_OF_MONTH);
        System.out.println(day);

        // 设置年月日
        calendar.set(2018, 5-1, 8); // 因为我们输入5月 变为索引要-1
        System.out.println(calendar);
    }
}
