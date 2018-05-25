package com.yiran3.entity1.javaThread.threadPool;

import com.yiran3.entity1.javaThread.ticket.Ticket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池的使用2
 *
 *  	1、定义线程执行目标
 *    		这里使用卖票的线程执行目标
 *    	2、向线程池提交线程
 *    		a、Future<?> submit(Runnable task):
 *    			接收一个Runnable，执行该线程执行目标
 *    		b、<T> Future<T> submit(Callable<T> task)：
 *    			接收一个Callable，执行该线程执行目标
 *    			Callable<T>:相当于有返回值的Runnable
 *    			V call() throws Exception
 *    			Future：任务的结果
 *    				V get() throws InterruptedException, ExecutionException
 *    					返回call方法的结果
 *
 * 上面的 V 不是指void  因为get、 call方法是有返回值的，这里应该指泛型
 * */

public class ThreadPoolDemo2 {
    public static void main(String[] args){
        // 返回一个线程池
        ExecutorService exec = Executors.newFixedThreadPool(3);

        // 创建线程执行目标----无返回值
        Ticket ticket = new Ticket();

        // 提交任务并查看其返回值---返回值为null
        try {
            Future<?> ticketFuture = exec.submit(ticket);
            System.out.println(ticketFuture.get());
        } catch (Exception e){
            e.printStackTrace();
        }


        // 创建线程执行目标----有返回值
        MyCallable1 callable = new MyCallable1();

        // 提交任务并查看其返回值---返回值为实现Callable接口的call方法的返回值
        try {
            Future<?> ticketFuture = exec.submit(callable);
            System.out.println(ticketFuture.get());
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
