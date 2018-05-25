package com.yiran3.entity1.javaThread.ticket;

/**
 * 多线程模拟火车站卖票
 *
 *    使用第二种创建并开启线程的方式，方便数据共享
 *
 *    1、定义卖票的线程执行目标
 *    		在成员变量位置将票定义为数字100，卖一张票，该数字减1，一直到小于0为止。
 *    		重写run方法，完成卖票逻辑
 *    		while(true){
 *    			if(有票){
 *    				//卖票
 *    				打印，xxx线程正在卖第几张票
 *    				每卖完一张票，要将票数-1
 *    			}else{
 *    				//没有票，跳出循环，结束程序
 *    			}
 *    		}
 *    2、创建卖票的线程执行目标对象
 *    3、使用该卖票线程执行目标对象创建多个线程
 *    4、开启多个线程
 * */

public class TicketDemo {
    public static void main(String[] args){
        // 创建卖票的线程执行目标对象
        Ticket ticket = new Ticket();

        // 使用该卖票线程执行目标对象 创建多个线程
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);

        // 开启多个线程，我们会发现，卖票的排行可能完全混乱了，甚至一张票卖了好几次
        // 这里就涉及到了后面会提到的，并发的问题，还有锁之类的。后面会了解
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
