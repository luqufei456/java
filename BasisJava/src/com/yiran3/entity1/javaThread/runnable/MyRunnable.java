package com.yiran3.entity1.javaThread.runnable;

/**
 * Runnable的实现类
 *
 *    定义了线程执行目标实现类
 * */

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        // 返回当前线程
        Thread thisThread = Thread.currentThread();

        for (int i = 0;i < 10;i++){
            // System.out.println("线程名称:"+i);
            System.out.println(thisThread.getName()+":"+i);
        }
    }
}
