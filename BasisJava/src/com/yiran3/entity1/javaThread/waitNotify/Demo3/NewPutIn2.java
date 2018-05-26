package com.yiran3.entity1.javaThread.waitNotify.Demo3;

import com.yiran3.entity1.javaThread.waitNotify.Demo1.ThreadPerson1;

/**
 * 生产类
 *
 * 使用共享对象锁及等待唤醒机制
 *
 * 生产者线程执行目标类
 *
 *    反复为Person对象赋值属性：蓝漓 男 与 杨戬 女
 * */

public class NewPutIn2 implements Runnable{
    // 我们发现，这里的person对象也可以作为锁使用
    private ThreadPerson1 threadPerson;

    // 通过构造方法，从外界接收共享资源  ThreadPerson
    public NewPutIn2(ThreadPerson1 threadPerson){
        this.threadPerson = threadPerson;
    }

    // 实现run()方法，使用共享对象锁及等待唤醒机制
    @Override
    public void run(){
        // 使用死循环达到反复生成的目的
        // 如果是奇数，生成蓝漓 男  如果是偶数，生成杨戬 女
        int i = 0;
        while (true){
            // 使用共享对象锁
            synchronized (threadPerson){
                // 判断标志位
                while (threadPerson.flag){
                    // 如果有数据，就进入等待状态
                    try {
                        // 这里是对 共享对象锁 进行操作
                        threadPerson.wait();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }

                // 如果没有数据或者刚刚被唤醒

                // 判断生产内容
                if (i % 2 == 1) {
                    threadPerson.name = "蓝漓";
                    // 睡眠150毫秒
                    try {
                        Thread.sleep(150);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    threadPerson.sex = "男";
                } else {
                    threadPerson.name = "杨戬";
                    // 睡眠150毫秒
                    try {
                        Thread.sleep(150);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    threadPerson.sex = "女";
                }

                System.out.println(threadPerson);
                System.out.println("生产了：" + threadPerson.name + "-" + threadPerson.sex);

                // 修改标记位为ture 表示有数据了
                threadPerson.flag = true;

                // 如果有消费者等待，就唤醒消费者，如果没有就无需唤醒，相当于这行代码无作用
                // 这里也是对 共享对象锁 进行操作，消费者也使用该锁
                threadPerson.notify();
            }

            // 每次生产完，更改奇偶对应的整数,只有一个线程操作，所以不锁也可以
            i++;
        }
    }
}
