package com.yiran3.entity1.javaThread.runnable;

/**
 * Java中的多线程
 *
 *  第二种方式创建线程：
 *    开启线程的步骤：
 *    	1、指定线程执行目标：定义Runnable线程执行目标实现类，重写run方法，指定目标逻辑
 *    	2、通过指定线程执行目标的构造方法创建线程对象
 *    		public Thread(Runnable target)
 *    		a)创建线程执行目标对象
 *    		b)通过线程执行目标创建线程对象
 *    	3、开启线程动作 (start开启线程)
 * */

public class ThreadDemo2 {
    public static void main(String[] args){
        // 开启线程

        // 创建线程执行目标
        MyRunnable mr = new MyRunnable();
        // 通过指定线程执行目标的构造方法创建线程对象
        Thread thread1 = new Thread(mr);
        thread1.setName("线程1");
        Thread thread2 = new Thread(mr);
        thread2.setName("线程2");

        // 开启线程动作
        thread1.start();
        thread2.start();

        // 返回main()线程
        Thread mainThread = Thread.currentThread();
        for (int i = 0;i < 10;i++){
            // System.out.println("main:"+i);
            System.out.println(mainThread.getName()+i);
        }
    }
}
