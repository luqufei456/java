package com.yiran3.entity1.javaThread.threadSafe;

import com.yiran3.entity1.javaThread.ticket.Ticket;

/**
 * 多线程安全问题
 *
 *   使用第二种创建并开启线程的方式，方便数据共享
 *
 *    Thread方法:
 *    	public static void sleep(long millis) throws InterruptedException
 *    		线程睡眠
 *
 *    安全问题原理分析：
 *    	共享数据
 *    	操作共享数据
 *    	一次完整的操作过程，应该不可以被分割执行，即该完整操作过程期间，不应该被其他线程抢夺CPU
 * */

public class TicketSafeDemo1 {
    public static void main(String[] args){
        // 创建卖票的线程执行目标对象
        Ticket ticket = new Ticket();

        // 使用该卖票线程执行目标对象 创建多个线程
        Thread thread1 = new Thread(ticket, "依然");
        Thread thread2 = new Thread(ticket, "蠢觉");
        Thread thread3 = new Thread(ticket, "红白白");

        // 开启多个线程
        thread1.start();
        thread2.start();
        thread3.start();

        // 使用sleep方法 进程休息单位为毫秒
        for (int i = 0;i < 50;i++){
            try {
                Thread.sleep(200);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
