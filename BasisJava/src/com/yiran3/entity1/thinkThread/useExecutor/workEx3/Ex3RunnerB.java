package com.yiran3.entity1.thinkThread.useExecutor.workEx3;

public class Ex3RunnerB implements Runnable{
    public Ex3RunnerB(){
        System.out.println("构造Ex3RunnerB");
    }

    public void run(){
        for (int i = 0;i < 3;i++){
            System.out.println("Hi from Ex3RunnerB");
            Thread.yield();
        }
        System.out.println("Ex3RunnerB任务完成");
        return;
    }
}
