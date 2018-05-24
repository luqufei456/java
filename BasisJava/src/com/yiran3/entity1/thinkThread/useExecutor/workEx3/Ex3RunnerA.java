package com.yiran3.entity1.thinkThread.useExecutor.workEx3;

/**
 * 三种Executor的练习
 *      CachedThreadPool
 *      FixedThreadPool
 *      SingleThreadExecutor
 * */

public class Ex3RunnerA implements Runnable {
    public Ex3RunnerA(){
        System.out.println("构造Ex3RunnerA");
    }

    public void run(){
        for (int i = 0;i < 3;i++){
            System.out.println("Hi from Ex3RunnerA");
            Thread.yield();
        }
        System.out.println("Ex3RunnerA任务完成");
        return;
    }
}
