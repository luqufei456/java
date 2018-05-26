package com.yiran3.entity1.javaThread.waitNotify.Demo2;

import com.yiran3.entity1.javaThread.waitNotify.Demo1.ThreadPerson1;

/**
 * 生产者
 *
 * 生产者和消费者线程安全解决：
 *    	将生产过程和消费过程都使用synchronized包裹代码块，并且使用共享对象作为锁。
 *
 * 生产者线程执行目标类
 *
 *    反复为Person对象赋值属性：蓝漓 男 与 杨戬 女
 * */

public class NewPutIn implements Runnable{
    // 我们发现，这里的person对象也可以作为锁使用
    private ThreadPerson1 threadPerson;

    // 通过构造方法，从外界接收共享资源  ThreadPerson
    public NewPutIn(ThreadPerson1 threadPerson){
        this.threadPerson = threadPerson;
    }

    // 实现run()方法
    @Override
    public void run(){
        // 使用死循环达到反复生成的目的
        // 如果是奇数，生成蓝漓 男  如果是偶数，生成杨戬 女
        int i = 0;
        while (true) {
            // 将共享对象作为锁
            synchronized (threadPerson) {
                // 判断生产内容
                if (i % 2 == 1) {
                    threadPerson.name = "蓝漓";
                    // 睡眠100毫秒
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    threadPerson.sex = "男";
                } else {
                    threadPerson.name = "杨戬";
                    // 睡眠100毫秒
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    threadPerson.sex = "女";
                }

                System.out.println(threadPerson);
                System.out.println("生产了：" + threadPerson.name + "-" + threadPerson.sex);

                // 每次生产完，更改奇偶对应的整数
                i++;
            }
        }
    }
}
