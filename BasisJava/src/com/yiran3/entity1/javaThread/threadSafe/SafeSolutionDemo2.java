package com.yiran3.entity1.javaThread.threadSafe;

/**
 * 同步方法：在方法声明上，返回值前加上synchronized
 *
 * public synchronized void method(){
 *     可能会产生线程安全问题的代码
 * }
 *
 * 同步方法中的锁对象是this
 *
 *   定义卖票的线程执行目标类
 *    不同同步代码块使用相同锁对象，依然可以起到同步效果
 * */

public class SafeSolutionDemo2 implements Runnable{
    private int num = 100;

    // 在成员位置定义锁对象
    private Object lock = new Object();

    // 定义一个标志位，让不同的线程执行不同的代码块
    private int x = 0;

    // 完成逻辑，定义不同代码块
    @Override
    public void run(){
        // 车站不停地在卖票
        while (true){
            if (x % 2 == 0){
                // 将一个完整动作使用synchronized同步代码块包裹，这里的锁对象为this，而不是lock
                // 即run()方法使用与sell()方法相同的锁对象，如果锁对象不同，仍然可能一票多卖
                // 因为不同的锁无法相互阻塞
                synchronized (this){
                    try {
                        Thread.sleep(20);
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                    // 有票就卖票
                    if (num > 0){
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName+"正在销售第"+num+"张票");
                        num--;
                    }
                }
            }
            else{
                // 调用sell方法
                this.sell();
            }

            if (num <= 0){
                // 没有票了，就停止
                break;
            }

            x++;
        }
    }

    // sell方法
    public synchronized void sell(){
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
