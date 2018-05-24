package com.yiran3.entity1.thinkThread.threadClass.workEx1;

public class Ex1RunnerC implements Runnable{
    public Ex1RunnerC(){
        System.out.println("构造Ex1RunnerC");
    }

    public void run(){
        for (int i = 0;i < 3;i++){
            System.out.println("Hi from Ex1RunnerC");
            // 转移另一个线程
            Thread.yield();
        }
        System.out.println("Ex1RunnerC任务完成");
        return;
    }
}
