package com.yiran3.entity1.javaThread.waitNotify.Demo1;

/**
 * 等待唤醒机制
 *
 *    开启生产者与消费者线程的主线程逻辑
 *
 *    生产者与消费者的线程执行目标可以通过构造方法传入共同操作的同一个资源对象
 *
 *    生产者生成：
 *    消费者消费：
 *
 *    多个线程在处理同一个资源，但是处理的动作（线程的任务）却不相同。
 * 通过一定的手段使各个线程能有效的利用资源。而这种手段即——等待唤醒机制。
 *
 * 可以发现，生产的和消费的有时候并不同
 * */

public class WaitNotifyDemo1 {
    public static void main(String[] args){
        // 创建共享资源
        ThreadPerson1 threadPerson = new ThreadPerson1();

        // 创建生产者线程执行目标
        ThreadPutIn putIn = new ThreadPutIn(threadPerson);

        // 创建消费者线程执行目标
        ThreadGetOut getOut = new ThreadGetOut(threadPerson);

        // 开启生产者线程
        Thread putInThread = new Thread(putIn);
        putInThread.start();

        // 开启消费者线程
        Thread getOutThread = new Thread(getOut);
        getOutThread.start();
    }
}