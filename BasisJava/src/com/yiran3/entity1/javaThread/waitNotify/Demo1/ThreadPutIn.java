package com.yiran3.entity1.javaThread.waitNotify.Demo1;

/**
 * 生产者类
 *
 *   生产者线程执行目标类
 *
 *    反复为Person对象赋值属性：蓝漓 男 与 杨戬 女
 * */

public class ThreadPutIn implements Runnable{
    private ThreadPerson1 threadPerson;

    // 通过构造方法，从外界接收共享资源  ThreadPerson
    public ThreadPutIn(ThreadPerson1 threadPerson){
        this.threadPerson = threadPerson;
    }

    // 实现run()方法
    @Override
    public void run(){
        // 使用死循环达到反复生成的目的
        // 如果是奇数，生成蓝漓 男  如果是偶数，生成杨戬 女
        int i = 0;
        while (true){
            // 睡眠100毫秒
            try {
                Thread.sleep(100);
            } catch (Exception e){
                e.printStackTrace();
            }

            // 判断生产内容
            if (i % 2 == 1){
                threadPerson.name = "蓝漓";
                threadPerson.sex = "男";
            }
            else {
                threadPerson.name = "杨戬";
                threadPerson.sex = "女";
            }

            System.out.println(threadPerson);
            System.out.println("生产了："+threadPerson.name+"-"+threadPerson.sex);

            // 每次生产完，更改奇偶对应的整数
            i++;
        }
    }
}
