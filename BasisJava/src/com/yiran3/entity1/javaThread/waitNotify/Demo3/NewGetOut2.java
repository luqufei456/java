package com.yiran3.entity1.javaThread.waitNotify.Demo3;

import com.yiran3.entity1.javaThread.waitNotify.Demo1.ThreadPerson1;

/**
 * 消费者
 *
 *  使用共享对象锁及等待唤醒机制
 *
 *    消费者线程执行目标类
 *
 *    反复获取Person对象的属性并打印
 * */

public class NewGetOut2 implements Runnable{
    // 我们发现，这里的person对象也可以作为锁使用
    private ThreadPerson1 threadPerson;

    // 通过构造方法，从外界接收共享资源  ThreadPerson
    public NewGetOut2(ThreadPerson1 threadPerson){
        this.threadPerson = threadPerson;
    }

    // 实现run()方法
    public void run(){
        // 使用死循环反复获取
        while (true){
            // 使用共享对象作为锁
            synchronized (threadPerson){
                // 判断标记位
                if (!threadPerson.flag){
                    // 如果没有数据，就等待生产者生产
                    try {
                        threadPerson.wait();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }

                // 如果有数据或刚刚被唤醒

                // 线程睡眠150ms
                try {
                    Thread.sleep(150);
                } catch (Exception e){
                    e.printStackTrace();
                }

                String name = threadPerson.name;
                String sex = threadPerson.sex;

                System.out.println(threadPerson);
                System.out.println("消费了："+name+"-"+sex);

                // 设置标记位为false
                threadPerson.flag = false;

                // 如果有生产者等待，就唤醒生产者，如果没有，那这段代码相当于无作用
                threadPerson.notify();

            }
        }
    }
}
