package com.yiran3.entity1.thinkThread.useExecutor;

import com.yiran3.entity1.thinkThread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool
 *
 *    你可以很容易地将前面示例中的CachedThreadPool替换为不同类型的Executor。
 * FixedThreadPool使用了有限的线程集来执行所提交的任务，即限定只能创建有限数个线程。
 *
 *    有了FixedThreadPool，你就可以一次性预先执行代价高昂的线程分配，因而也就可以限制
 * 线程的数量了。这可以节省时间，因为你不用为每个任务都固定地付出创建线程的开销。在事件
 * 驱动的系统中，需要线程的事件处理器，通过直接从池中获取线程，也可以如你所愿地尽快得到服务。
 * 你不会滥用可获得的资源，因为FixedThreadPool使用的Thread对象的数量是有界限的。
 *
 *    注意，在任何线程池中，现有线程在可能的情况下，都会被复用。
 *
 *    尽管think in java 将使用CachedThreadPool，但是也应该考虑在产生线程的代码中使用
 * FixedThreadPool。CachedThreadPool在程序执行时通常会创建与所需数量相同的线程，然后
 * 在它回收旧线程时停止创建新线程，因此它是合理的Executor的首选。只有当这种方式会引发问题
 * 时，你才需要切换到FixedThreadPool。
 * */

public class FixedThreadPool {
    public static void main(String[] args){
        // 构造函数中的参数即为线程的个数
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0;i < 5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
