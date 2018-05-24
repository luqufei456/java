package com.yiran3.entity1.thinkThread.useExecutor;

import com.yiran3.entity1.thinkThread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Executor
 *
 *    java SE5的java.util.concurrent包中的执行器(Executor)将为你管理Thread对象，
 * 从而简化了并发编程。Executor在客户端和任务执行之间提供了一个间接层；与客户端直接
 * 执行任务不同，这个中介对象将执行任务。Executor允许你管理异步任务的执行，而无需
 * 显式地管理线程的生命周期。Executor在java SE5/6 中是启动任务的优选方法。
 *
 *    我们可以使用Executor来代替在MoreBasicThreads.java中显式地创建对象。LiftOff
 * 对象知道如何运行具体的任务，与命令设计模式一样，它暴露了要执行的单一方法。ExecutorService
 * (具有服务生命周期的Executor，例如关闭)知道如何构建恰当的上下文来执行Runnable对象。
 *
 *    在下面的示例中，CachedThreadPool将为每个任务都创建一个线程。注意，ExecutorService
 * 对象是使用静态的Executor方法创建的，这个方法可以确定其Executor类型。
 *
 *    非常常见的情况是，单个的Executor被用来创建和管理系统中的所有任务。
 *
 *    对shutdown()方法的调用可以防止新任务被提交给这个Executor，当前线程(在本例中，即驱动
 * main()的线程)将继续运行在shutdown()被调用之前提交的所有任务。这个程序将在Executor中的
 * 所有任务运行完成之后尽快退出。(也就是说不会执行到shutdown()就全部退出了，会等运行完任务再退出)
 * */

public class CachedThreadPool {
    public static void main(String[] args){
        // 使用Executors的静态方法创建一个ExecutorService对象
        ExecutorService exec = Executors.newCachedThreadPool();
        // 使用执行器创建5个线程
        for (int i = 0;i < 5;i++){
            exec.execute(new LiftOff());
        }
        // 在以上所有任务运行完成之后尽快退出
        exec.shutdown();
    }
}
