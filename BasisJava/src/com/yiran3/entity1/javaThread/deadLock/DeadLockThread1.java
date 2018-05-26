package com.yiran3.entity1.javaThread.deadLock;

/**
 * 死锁示例
 * */

public class DeadLockThread1 implements Runnable{
    // 定义两个锁对象
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    // 定义标记，用来指定要执行的代码
    public boolean flag;

    public DeadLockThread1(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run(){
        // flag赋值为true时，执行以下下代码
        if (flag){
            synchronized (Lock1){
                System.out.println("if判断中的Lock1");
                // 线程睡眠100毫秒
                try {
                    Thread.sleep(100);
                } catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (Lock2){
                    System.out.println("if判断中的Lock2");
                }
            }
        }
        // flag赋值为false时，执行以下代码
        else{
            synchronized (Lock2){
                System.out.println("else判断中的Lock2");
                // 线程睡眠100毫秒
                try {
                    Thread.sleep(100);
                } catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (Lock1){
                    System.out.println("else判断中的Lock1");
                }
            }
        }
    }
}
