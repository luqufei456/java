package com.yiran3.entity1.thinkThread.threadClass.workEx1;

/**
 *   实现一个Runnable。在run()内部打印一个消息，然后调用yield()。重复
 * 这个操作三次，然后从run()返回。在构造器中放置一条启动消息，并且放置一条
 * 在任务终止时的关闭消息。使用线程创建大量的这种任务并驱动它们
 * */

public class Ex1RunnerA implements Runnable{
    public Ex1RunnerA(){
        System.out.println("构造Ex1RunnerA");
    }

    @Override
    public void run(){
        for (int i = 0;i < 3;i++){
            System.out.println("Hi from Ex1RunnerA");
            // 转移另一个线程
            Thread.yield();
        }
        System.out.println("Ex1RunnerA任务完成");
        return;
    }
}
