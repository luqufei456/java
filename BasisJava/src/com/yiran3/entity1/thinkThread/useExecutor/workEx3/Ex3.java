package com.yiran3.entity1.thinkThread.useExecutor.workEx3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * think in java  Thread习题3
 * */

public class Ex3 {
    public static void main(String[] args){
        // CachedThreadPool
        ExecutorService execCached = Executors.newCachedThreadPool();
        execCached.execute(new Ex3RunnerA());
        execCached.execute(new Ex3RunnerB());
        execCached.execute(new Ex3RunnerC());
        execCached.shutdown();

        // FixedThreadPool
        ExecutorService execFixed = Executors.newFixedThreadPool(3);
        execFixed.execute(new Ex3RunnerA());
        execFixed.execute(new Ex3RunnerB());
        execFixed.execute(new Ex3RunnerC());
        execFixed.shutdown();

        // SingleThreadExecutor
        // 线程运行是一定队列的，但是其中的run方法类的构造则不一定等上一个任务完了才开始构造
        ExecutorService execSingle = Executors.newSingleThreadExecutor();
        execSingle.execute(new Ex3RunnerA());
        execSingle.execute(new Ex3RunnerB());
        execSingle.execute(new Ex3RunnerC());
        execSingle.shutdown();
    }
}
