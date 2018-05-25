package com.yiran3.entity1.thinkThread;

/**
 * think in java 多线程第一个小例子----定义任务
 *
 *    描述任务的方式由Runnable接口提供，要想定义任务，只需要实现
 * Runnable接口并编写run()方法，使得该任务可以执行你的命令。
 *
 * 显示发射前的倒计时，定义任务
 *
 * 定义任务 需要重写run方法
 *
 *    这个run()方法并无特殊之处---不会产生任何的内在的线程能力。
 * 要实现线程行为，你必须显式地将一个任务附着到线程上
 * 所以这里运行结果显示都是同一个进程id为0的进程返回了值
 * 只是创建了10个子进程，但是并没有使用子进程
 *
 *     在run()中的Thread.yield()的调用是对线程调度器(java线程机制的一部分，可以将
 * cpu从一个线程转移给另一个线程)的一种建议，它在声明："我已经执行完生命周期中最
 * 重要的部分了，此刻正是切换给其他任务执行一段时间的大好时机."这完全是选择性的。
 * */

public class LiftOff implements Runnable{
    // 倒计时
    protected int countDown = 10; // 设置一个默认值
    // 任务数
    private static int taskCount = 0;
    // 线程id
    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    // 状态统计方法，返回当前是哪个进程
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"Liftoff!")+"), ";
    }

    @Override
    public void run(){
        while (countDown-- > 0){
            System.out.print(status());
            Thread.yield();
        }
    }

}
