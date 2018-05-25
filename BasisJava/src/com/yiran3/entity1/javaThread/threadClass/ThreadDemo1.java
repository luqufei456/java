package com.yiran3.entity1.javaThread.threadClass;

/**
 * Java中的多线程
 *
 *    A：java支持多线程。
 *
 *    B：当java程序执行main方法的时候，就是在执行一个名字叫做main的线程。
 *     	可以在main方法执行时，开启多个线程A、B、C。
 *     	多个线程main，A，B，C同时执行，相互抢夺CPU。
 *
 *    C：Thread类是java.lang包下的一个常用类，每一个Thread类的对象，就代表一个处于某种状态的线程。
 *
 *    第一种方式创建线程：
 *    开启线程的步骤：
 *    	1、指定线程执行目标：定义一个Thread类的子类，重写run方法，将相关逻辑实现
 *    		public void run() 线程要执行的业务逻辑方法，相当于该线程的"main方法"
 *    	2、创建自定义的线程子类对象
 *    	3、开启线程动作
 *    		public void start() 使该线程开始执行
 *
 *    Thread类的一些方法：
 *    	public final String getName()  			获取线程名称
 *    	public final void setName(String name) 	指定线程名称
 *    	public static Thread currentThread()  	获取当前线程对象
 * */

public class ThreadDemo1 {
    public static void main(String[] args){
        // 开启线程
        // 创建线程对象
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        // 开启线程动作
        myThread1.start();

        // 为什么每次都是先输出这里的for循环，这是因为分配资源需要时间，然后这里的for循环
        // 设置的i过少，对计算机来说运行该循环几乎不需要时间，所以for循环循环完毕时，可能
        // 子进程还没进入运行状态，设置成10W次，就比较容易看出其规律
        for (int i = 0;i < 100000;i++){
            System.out.println(i);
        }

        myThread2.start();

        // 返回main线程
        Thread mainThread = Thread.currentThread();

        for (int i = 0;i < 10;i++){
            // System.out.println("main:"+i);
            System.out.println(mainThread.getName()+i);
        }

    }
}
