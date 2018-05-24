package com.yiran3.entity1.thinkThread.threadClass.workEx1;

public class Ex1RunnerB implements Runnable{
    public Ex1RunnerB(){
        System.out.println("构造Ex1RunnerB");
    }

    public void run(){
        for (int i = 0;i < 3;i++){
            System.out.println("Hi from Ex1RunnerB");
            // 转移另一个线程
            Thread.yield();
        }
        System.out.println("Ex1RunnerB任务完成");
        return;
    }
}
