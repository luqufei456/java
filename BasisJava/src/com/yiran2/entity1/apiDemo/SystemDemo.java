package com.yiran2.entity1.apiDemo;

/**
 * System类常用方法
 *
 * public static void exit(int status)：让操作系统终止该java程序  0代表正常终止
 * public static void gc()：暗示java虚拟机回收不使用的对象(垃圾)
 * public static String getProperty(String key) ：查找制定的系统属性 , 系统属性参照API
 * public static void setProperty(String key,String value);   设置系统属性
 * */

public class SystemDemo {
    public static void main(String[] args){
        // 标准输出与错误输出
        // 标准输出
        System.out.println("i love python");
        // 错误输出
        System.err.println("i love python"); // 红色输出 而且在后面

        // 设置系统属性
        System.setProperty("user","yiran");

        // 获取指定的系统属性
        System.out.println(System.getProperty("user")); // yiran

        // 暗示回收垃圾
        System.gc();

        // 终止java程序
        System.exit(0);
        System.out.println("终止后，无法输出");
    }
}
