package com.yiran3.entity1.thinkThread.threadClass.workEx2;

public class Ex2FibonacciB implements Runnable{
    private int n = 0;

    public Ex2FibonacciB(int n){
        this.n = n;
    }

    private int fib(int x){
        if (x < 2){
            return 1;
        }
        // x 代表斐波拉契中的第几个数，第三个数=前两个数之和
        return fib(x - 2) + fib(x - 1);
    }

    @Override
    public void run(){
        // 返回n个斐波拉契数字组成的序列
        for (int i = 0;i < n;i++){
            System.out.print(fib(i)+" ");
            System.out.println();
        }
    }
}
