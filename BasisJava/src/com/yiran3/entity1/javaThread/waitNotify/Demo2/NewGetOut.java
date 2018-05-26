package com.yiran3.entity1.javaThread.waitNotify.Demo2;

import com.yiran3.entity1.javaThread.waitNotify.Demo1.ThreadPerson1;

/**
 * 消费者
 *
 * 生产者和消费者线程安全解决：
 *    	将生产过程和消费过程都使用synchronized包裹代码块，并且使用共享对象作为锁。
 *
 *    消费者线程执行目标类
 *
 *    反复获取Person对象的属性并打印
 * */

public class NewGetOut implements Runnable{
    // 我们发现，这里的person对象也可以作为锁使用
    private ThreadPerson1 threadPerson;

    // 通过构造方法，从外界接收共享资源  ThreadPerson
    public NewGetOut(ThreadPerson1 threadPerson){
        this.threadPerson = threadPerson;
    }

    // 实现run()方法
    @Override
    public void run(){
        // 使用死循环反复获取
        while (true){
            // 使用共享对象作为锁
            synchronized (threadPerson){
                // 线程休息100毫秒
                try {
                    Thread.sleep(100);
                } catch (Exception e){
                    e.printStackTrace();
                }

                String name = threadPerson.name;
                String sex = threadPerson.sex;

                System.out.println(threadPerson);
                System.out.println("消费了："+name+"-"+sex);
            }
        }
    }
}
