package com.yiran3.entity1.javaThread.deadLock;

/**
 * 死锁的测试类
 *
 * 第一个线程占据了锁1 第二个线程占据了锁2  两者都持有锁的同时等待另一个锁打开
 * 然后进入死循环，谁都不能解锁
 * */

public class DeadLockTest1 {
    public static void main(String[] args){
        DeadLockThread1 lock1 = new DeadLockThread1(true);
        DeadLockThread1 lock2 = new DeadLockThread1(false);

        Thread thread1 = new Thread(lock1);
        Thread thread2 = new Thread(lock2);

        thread1.start();
        thread2.start();
    }
}
