package com.yiran3.entity1.thinkThread.useExecutor.workEx4;

/**
 * 三种Executor的练习 --- 斐波拉契数列
 *      CachedThreadPool
 *      FixedThreadPool
 *      SingleThreadExecutor
 * */

public class Ex4FibonacciA implements Runnable{
    private int n = 0;

    public Ex4FibonacciA(int n){
        this.n = n;
    }

    private int fib(int x){
        if (x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }

    @Override
    public void run(){
        for (int i = 0;i < n;i++){
            System.out.print(fib(i)+" ");
            System.out.println();
        }
    }
}
