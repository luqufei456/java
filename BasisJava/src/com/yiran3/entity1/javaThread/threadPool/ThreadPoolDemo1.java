package com.yiran3.entity1.javaThread.threadPool;

import com.yiran3.entity1.javaThread.ticket.Ticket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用
 *
 *   线程池，其实就是一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁创建线程对象的操作，无需反复创建线程而消耗过多资源。
 *
 *    Executors：线程池创建工厂类
 *    	返回线程池方法：
 *    		public static ExecutorService newFixedThreadPool(int nThreads)：
 *    			返回固定线程个数的线程池
 *
 *    ExecutorService：线程池类
 *    	线程池赋值线程的生命周期，我们只需要向线程提交执行目标，线程池会自动分配线程，执行对应的操作
 *
 *    	1、定义线程执行目标
 *    		这里使用卖票的线程执行目标
 *    	2、向线程池提交线程
 *    		Future<?> submit(Runnable task):
 *    			接收一个Runnable，执行该线程执行目标,并且会产生一个Future对象
 *    		Future接口：
 *    		    用来记录线程任务执行完毕后产生的结果。
 * */

public class ThreadPoolDemo1 {
    public static void main(String[] args){
        // 返回一个线程池
        ExecutorService exec = Executors.newFixedThreadPool(3);

        // 创建线程执行目标
        Ticket ticket = new Ticket();

        // 像线程池提交任务
        exec.submit(ticket);
        exec.submit(ticket);
        exec.submit(ticket);
        exec.submit(ticket);

        // 关闭线程池
        exec.shutdown();
    }
}
