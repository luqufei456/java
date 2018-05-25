package com.yiran3.entity1.javaThread.anonymousThread;

/**
 * 利用匿名内部类创建线程
 *
 *   使用匿名内部类开启线程
 * */

public class AnonymousThreadDemo1 {
    public static void main(String[] args){
        // 方式一：
        // 使用匿名内部类创建线程的子类对象
        Thread thread1 = new Thread(){
            // 重写run方法
            @Override
            public void run(){
                System.out.println("线程执行了-1");
            }
        };

        // 开启线程
        thread1.start();


        // 使用匿名内部类创建线程的子类匿名对象，因为没有被指向所以直接开启
        new Thread(){
            // 重写run方法
            @Override
            public void run(){
                System.out.println("线程执行了-2");
            }
        }.start();


        // 方式二：
        // 使用匿名内部类的方式，创建线程执行目标的对象
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行目标，执行了-1");
            }
        };


        // 通过目标创建线程对象
        Thread thread2 = new Thread(runnable);

        // 开启线程
        thread2.start();

        // 使用匿名内部类的方式，创建线程执行目标类的匿名对象
        // 通过目标创建线程对象
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行目标，执行了-2");
            }
        });

        // 开启线程
        thread3.start();


        // 使用匿名内部类的方式，创建线程执行目标类的匿名对象
        // 通过目标创建线程对象
        // 开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable、Thread双匿名，执行了");
            }
        }).start();
    }
}
