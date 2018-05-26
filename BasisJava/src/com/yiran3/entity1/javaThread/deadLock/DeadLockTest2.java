package com.yiran3.entity1.javaThread.deadLock;

/**
 * 使用显式的lock对象来解决死锁问题的测试类
 *
 * 守护线程与用户线程
 *
 * 用户线程和守护线程都是线程，区别是Java虚拟机在所有用户线程dead后，程序就会结束。
 * 而不管是否还有守护线程还在运行，若守护线程还在运行，则会马上结束。很好理解，
 * 守护线程是用来辅助用户线程的，如公司的保安和员工，各司其职，当员工都离开后，保安自然下班了。
 * */

public class DeadLockTest2 {
    public static void main(String[] args){
        DeadLockThread2 admin = new DeadLockThread2();
        admin.untimed();
        admin.timed();

        // 现在创建一个单独的任务来获取锁
        new Thread(){
            // 设置为守护线程，服务于用户线程
            {setDaemon(true);}
            public void run(){
                // 表示lock执行锁定。
                admin.lock.lock();
                System.out.println("获得锁");
            }
        }.start();

        // 设置一个延迟
        try {
            Thread.sleep(1000);
        } catch (Exception e){
            e.printStackTrace();
        }

        // 给第二项任务一个机会
        Thread.yield();
        // 可以发现后面没有取到锁，而且并没有卡死
        admin.untimed();
        admin.timed();
    }
}
