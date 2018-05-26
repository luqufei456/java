package com.yiran3.entity1.javaThread.waitNotify.Demo1;

/**
 * Person资源类
 *
 *    定义共享资源Person，其中有三个成员变量：name、sex、flag
 * */

public class ThreadPerson1 {
    public String name;
    public String sex;

    // flag : 定义布尔值，作为判断哪个线程等待的标记位：
    // true有数据，生产者等待；false无数据，消费者等待；
    // 在Demo3运用等待唤醒时候会用到 默认值设为false
    public Boolean flag = false;

    public ThreadPerson1(){}
}
