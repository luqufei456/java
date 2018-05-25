package com.yiran3.entity1.javaThread.threadSafe;

/**
 * 线程安全解决方案测试类
 *      -- 同步代码块
 *      -- 同步方法 synchronized锁住方法后，别的线程就无法访问了，所以如果run方法也锁住
 *      那么结果将只有第一个被启动的线程运行到结束，其余的线程始终被阻塞
 * */

public class SafeTestDemo1 {
    public static void main(String[] args){
        safeTest2();
    }

    public static void safeTest1(){
        // 测试同步代码块的解决方案
        SafeSolutionDemo1 ssd1 = new SafeSolutionDemo1();

        // 创建多个线程进行测试
        Thread t1 = new Thread(ssd1, "依然");
        Thread t2 = new Thread(ssd1, "蠢觉");
        Thread t3 = new Thread(ssd1, "红白白");

        t1.start();
        t2.start();
        t3.start();
    }

    public static void safeTest2(){
        // 测试同步方法中  不同同步代码块使用相同锁对象 的同步效果
        SafeSolutionDemo2 ssd2 = new SafeSolutionDemo2();

        // 创建多个线程进行测试
        Thread t1 = new Thread(ssd2, "依然");
        Thread t2 = new Thread(ssd2, "蠢觉");
        Thread t3 = new Thread(ssd2, "红白白");

        t1.start();
        t2.start();
        t3.start();
    }
}
