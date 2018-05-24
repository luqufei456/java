package com.yiran3.entity1.thinkThread.useExecutor;

import com.yiran3.entity1.thinkThread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadExecutor
 *
 *    SingleThreadExecutor就像是线程数量为1的FixedThreadPool(它还提供了一种重要的
 * 并发保证，其他线程不会(即没有两个线程会)被并发调用，这会改变任务的加锁需求(后面会学习))。
 * 这对你希望在另一个线程中连续运行的任何事物(长期存活的任务)来说，都是很有用的，例如监听
 * 进入的套接字连接的任务。它对于希望在线程中运行的短任务同样也很方便，例如，更新本地或
 * 远程日志的小任务，或者是事件分发线程。
 *
 *    如果像SingleThreadExecutor提交了多个任务，那么这些任务将排队，每个任务都会在
 * 下一个任务开始之前运行结束，所有的任务将使用相同的线程。在下面的示例中，你可以看到
 * 每个任务都是按照它们被提交的顺序，并且是在下一个任务开始之前完成的。因此，SingleThreadExecutor
 * 会序列化所有提交给它的任务，并会维护它自己(隐藏)的悬挂任务队列。
 *
 *    作为另一个示例，假设你有大量线程，那它们运行的任务将使用文件系统。你可以用
 * SingleThreadExecutor来运行这些线程，以确保任意时刻在任何线程中都只有唯一的任务
 * 在运行。在这种方式中，你不需要在共享资源上处理同步(同时不会过度使用文件系统)。有时
 * 更好的解决方案是在资源上同步(后面会讲)，但是SingleThreadExecutor可以让你省去的
 * 只是为了维持某些事物的原型而进行的各种协调努力。通过序列化任务，你可以消除对序列化
 * 对象的需求。
 * */

public class SingleThreadExecutor {
    public static void main(String[] args){
        // 创建对象
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0;i < 5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
