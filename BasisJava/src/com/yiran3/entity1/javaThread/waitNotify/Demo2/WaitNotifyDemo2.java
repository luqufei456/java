package com.yiran3.entity1.javaThread.waitNotify.Demo2;

import com.yiran3.entity1.javaThread.waitNotify.Demo1.ThreadPerson1;

/**
 * 等待唤醒机制
 *
 *    开启生产者与消费者线程的主线程逻辑
 *
 *    生产者与消费者的线程执行目标可以通过构造方法传入共同操作的同一个资源对象
 *
 *    生产者和消费者线程安全解决：
 *    	将生产过程和消费过程都使用synchronized包裹代码块，并且使用共享对象作为锁。
 *
 *    生产者生成：
 *    消费者消费：
 *
 *    emm 就这个结果来看，感觉还是不太如人意，有时创建一堆 又消费一堆，无法判定是否对称
 * 应该是有问题的。
 * */

public class WaitNotifyDemo2 {
    public static void main(String[] args){
        // 创建共享资源
        ThreadPerson1 threadPerson = new ThreadPerson1();

        // 创建生产者线程执行目标
        NewPutIn putIn = new NewPutIn(threadPerson);

        // 创建消费者线程执行目标
        NewGetOut getOut = new NewGetOut(threadPerson);

        // 开启生产者线程
        Thread putInThread = new Thread(putIn);
        putInThread.start();

        // 开启消费者线程
        Thread getOutThread = new Thread(getOut);
        getOutThread.start();
    }
}
