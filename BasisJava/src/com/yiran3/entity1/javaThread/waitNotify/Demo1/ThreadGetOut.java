package com.yiran3.entity1.javaThread.waitNotify.Demo1;

/**
 * 消费者
 *
 *    消费者线程执行目标类
 *
 *    反复获取Person对象的属性并打印
 * */

public class ThreadGetOut implements Runnable{
    private ThreadPerson1 threadPerson;

    // 通过构造方法，从外界接收共享的那个资源
    public ThreadGetOut(ThreadPerson1 threadPerson){
        this.threadPerson = threadPerson;
    }

    // 实现run()方法
    @Override
    public void run(){
        // 使用死循环来达到反复消费的目的
        while (true){
            // 线程睡眠100毫秒
            try {
                Thread.sleep(100);
            } catch (Exception e){
                e.printStackTrace();
            }

            // 消费
            String name = threadPerson.name;
            String sex = threadPerson.sex;

            System.out.println(threadPerson);
            System.out.println("消费了："+name+"-"+sex);
        }
    }
}
