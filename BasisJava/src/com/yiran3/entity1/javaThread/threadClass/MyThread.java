package com.yiran3.entity1.javaThread.threadClass;

/**
 * 自定义线程类
 *
 *    定义了一个Thread类的子类线程
 * */

public class MyThread extends Thread{
    @Override
    public void run(){
        for(int i = 0;i < 10;i++){
            //System.out.println("MyThread:"+i);
            // 线程的getName方法，可以获取当前线程名
            System.out.println(this.getName()+":"+i);
        }
    }
}
