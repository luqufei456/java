package com.yiran3.entity1.javaThread.ticket;

/**
 * 卖票类
 *
 *   定义卖票的线程执行目标类
 * */

public class Ticket implements Runnable{
    // 定义票数
    private int num = 100;

    // 完成卖票的线程逻辑
    @Override
    public void run(){
        // 车站不停的在卖票
        while (true){
            // 有票就可以买票
            if (num > 0){
                // 看是哪个线程在卖票
                System.out.println(Thread.currentThread().getName()+"正在卖第"+num+"张票");
                num--;
            }
            else {
                return;
            }
        }
    }
}
