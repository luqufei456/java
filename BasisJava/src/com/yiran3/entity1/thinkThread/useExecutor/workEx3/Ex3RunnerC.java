package com.yiran3.entity1.thinkThread.useExecutor.workEx3;

public class Ex3RunnerC implements Runnable{
    public Ex3RunnerC(){
        System.out.println("构造Ex3RunnerC");
    }

    public void run(){
        for (int i = 0;i < 3;i++){
            System.out.println("Hi from Ex3RunnerC");
            Thread.yield();
        }
        System.out.println("Ex3RunnerC任务完成");
        return;
    }
}
