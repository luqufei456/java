package com.yiran3.entity1.javaThread.deadLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁的解决方案：使用显式的lock对象,而不是内置的synchronized
 *
 * tryLock()尝试获取锁，获取失败也可以做别的，也可以设置时间
 * unLock() 释放锁
 * */

public class DeadLockThread2 {
    // 显式的lock对象
    public ReentrantLock lock = new ReentrantLock();

    public void untimed(){
        // tryLock 尝试获取锁 如果成功，返回ture 如果失败，返回false
        boolean captured = lock.tryLock();

        // 为什么这里要用try，这是为了将这里所示的惯用方法内部化
        // 紧接着对lock()的调用，必须放在带有unlock()的try-finally
        // 语句中。return必须在try子句中，以确保unlock()不会过早发生
        // 否则一样容易导致数据混乱
        try {
            System.out.println("是否获取到了锁："+captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed(){
        // 这里定义一个初始值
        boolean captured = false;
        try {
            // 这里是尝试获取锁 如果2s没有获取到，就失败
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            System.out.println("2s内是否获取到了锁：" + captured);
        } finally {
            if (captured){
                lock.unlock();
            }
        }

    }
}
