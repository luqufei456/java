package com.yiran2.entity1.apiDemo;

/**
 * Math:数学工具类
 *
 * 如果方法不需要访问成员变量,只关注方法功能本身,则该方法可以定义为静态方法,通常定义这样方法的类为工具类
 *
 * Math当中所有字段与方法均为静态,无需创建对象(无法创建对象).直接使用类名调用.
 *
 * public static int abs(int a)：返回a的绝对值
 * public static double ceil(double a) ：求大于等于a的最小整数,返回该整数的小数形式
 * public static double floor(double a) ：求小于等于a的最大整数
 * public static long round(double a) ：对a进行四舍五入,返回四舍五入后的值
 * public static double pow(double a, double b) ：求a的b次幂,返回double形式
 * */

public class MathDemo {
    public static void main(String[] args){
        // 访问静态变量
        System.out.println(Math.PI); // 3.141592653589793

        // 访问静态方法
        // 求绝对值
        System.out.println(Math.abs(-105)); // 105

        // 向下取整
        System.out.println(Math.ceil(1.25)); // 向上取整 2.0
        System.out.println(Math.floor(1.25)); // 向下取整 1.0
        System.out.println(Math.round(1.25)); // 四舍五入 1
        System.out.println(Math.round(1.75)); // 四舍五入 2

        // 求第一个参数的，第二个参数 的次方是多少 返回double
        System.out.println(Math.pow(2,3)); // 8.0
    }
}
