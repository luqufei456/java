package com.yiran2.entity1.apiDemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormat:日期格式化类
 * SimpleDateFormat:实际使用的日期格式化子类
 *
 * 在创建SimpleDateFormat对象时,可以指定生成字符串的模板,规则见API帮助文档
 * 模板是一个字符串,代表转换规则:特殊字母代表一定的时间组成部分
 *
 * public final String format(Date date)  将日期格式化成字符串
 * */

public class DateFormatDemo {
    public static void main(String[] args){
        // 定义日期规则字符串 这个东西好像不能改，改了报错 吗的智障
        String rule = "yyyy年MM月dd日HH:mm:ss";
        // 使用日期转换规则，创建日期格式化对象
        DateFormat sdf = new SimpleDateFormat(rule);

        // 准备要转换的日期对象
        Date date = new Date();
        // 转换date为String字符串
        String time = sdf.format(date);

        // 打印结果
        System.out.println(date);
        System.out.println(time);

        DateFormatDemo demo = new DateFormatDemo();
        demo.ToDete();
    }

    public void ToDete(){
        //定义日期规则字符串
        String rule = "yyyy年MM月dd日HH:mm:ss";
        //创建日期格式化类对象
        DateFormat sdf = new SimpleDateFormat(rule);

        //准备日期字符串
        String sTime = "2017年11月06日  14:10:28";

        try {
            //转换生成Date对象
            Date dTime = sdf.parse(sTime);
            //打印Date对象
            System.out.println(dTime);
        } catch (ParseException pe){
            System.out.println("您输入的日期字符串格式不正确");
        }
    }
}
