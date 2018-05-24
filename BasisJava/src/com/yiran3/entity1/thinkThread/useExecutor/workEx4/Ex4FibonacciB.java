package com.yiran3.entity1.thinkThread.useExecutor.workEx4;

public class Ex4FibonacciB implements Runnable{
    private int n = 0;

    public Ex4FibonacciB(int n){
        this.n = n;
    }

    private int fib(int x){
        if (x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }

    public void run(){
        for (int i = 0;i < n;i++){
            System.out.print(fib(i)+" ");
            System.out.println();
        }
    }
}
