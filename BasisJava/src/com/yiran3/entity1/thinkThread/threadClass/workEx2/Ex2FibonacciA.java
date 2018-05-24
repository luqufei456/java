package com.yiran3.entity1.thinkThread.threadClass.workEx2;

/**
 * 遵循generic/Fibonacci.java的形式，创建一个任务，它可以产生由n个斐波拉契数字组成的序列，
 * 其中n是通过任务的构造器而提供的。使用线程创建大量的这种任务并驱动它们。
 * */

public class Ex2FibonacciA implements Runnable{
    private int n = 0;

    public Ex2FibonacciA(int n){
        this.n = n;
    }

    private int fib(int x){
        if (x < 2){
            return 1;
        }
        // x 代表斐波拉契中的第几个数，第三个数=前两个数之和
        return fib(x - 2) + fib(x - 1);
    }

    public void run(){
        // 返回n个斐波拉契数字组成的序列
        for (int i = 0;i < n;i++){
            System.out.print(fib(i)+" ");
            System.out.println();
        }
    }

}
