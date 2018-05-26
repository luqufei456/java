package com.yiran3.entity1.javaThread.threadSafe;

import com.yiran3.entity1.javaThread.ticket.Ticket;

/**
 * 静态同步方法:
 *
 * 在方法声明上，加上static synchronized
 *
 *     public static synchronized void method(){
 *         可能会产生线程安全问题的代码
 *     }
 *
 *     静态同步方法中的锁对象是 类名.class
 *
 *    不同同步代码块使用相同锁对象，依然可以起到同步效果，所以
 *    这里另一块代码块的锁对象就要用  类名.class
 * */

public class SafeSolutionDemo3 implements Runnable{
    // 定义 票的数量为100
    private static int num = 100;

    // 在成员位置定义锁对象 测试了几次，使用同步方法的锁对象时，不需要额外定义锁对象
    // private Object lock = new Object();

    // 定义一个标志位，让不同的线程执行不同的代码块
    // 因为测试的时候是一个执行目标对象 被不同线程执行，所以相当于共享 x
    private int x = 0;

    // 完成卖票逻辑
    @Override
    public void run(){
        // 不停地卖票
        while (true){
            if (x % 2 == 0){
                // 将完整的动作用synchronized包裹
                synchronized (SafeSolutionDemo3.class){
                    try {
                        Thread.sleep(20);
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                    // 有票就买票
                    if (num > 0){
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName+"正在销售第"+num+"张票");
                        num--;
                    }
                }
            }
            else{
                SafeSolutionDemo3.sell();
            }

            if (num <=0){
                // 没有票就跳出循环
                break;
            }
            // x递增
            x++;
        }
    }

    // 定义卖票的静态同步方法
    public static synchronized void sell(){
        // 线程暂停20毫秒
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 有票就买票
        if(num>0){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+"正在销售第"+num+"张票");
            num--;
        }
    }

}
