package com.yiran3.entity1.thinkThread.useExecutor.workEx4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * think in java  Thread习题4
 * */

public class Ex4 {
    public static void main(String[] args){
        // CachedThreadPool
        ExecutorService execCached = Executors.newCachedThreadPool();
        execCached.execute(new Ex4FibonacciA(15));
        execCached.execute(new Ex4FibonacciB(15));
        execCached.execute(new Ex4FibonacciC(15));
        execCached.execute(new Ex4FibonacciD(15));
        execCached.shutdown();

        // FixedThreadPool
        ExecutorService execFixed = Executors.newFixedThreadPool(4);
        execFixed.execute(new Ex4FibonacciA(15));
        execFixed.execute(new Ex4FibonacciB(15));
        execFixed.execute(new Ex4FibonacciC(15));
        execFixed.execute(new Ex4FibonacciD(15));
        execFixed.shutdown();

        // SingleThreadExecutor
        ExecutorService execSingle = Executors.newSingleThreadExecutor();
        execSingle.execute(new Ex4FibonacciA(15));
        execSingle.execute(new Ex4FibonacciB(15));
        execSingle.execute(new Ex4FibonacciC(15));
        execSingle.execute(new Ex4FibonacciD(15));
        execSingle.shutdown();
    }
}
