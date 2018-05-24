package com.yiran3.entity1.thinkThread.threadClass.workEx2;

/**
 * think in java  Thread习题2
 * */

public class Ex2 {
    public static void main(String[] args){
        // 创建4个线程并启动
        Thread f1 = new Thread(new Ex2FibonacciA(15));
        Thread f2 = new Thread(new Ex2FibonacciB(15));
        Thread f3 = new Thread(new Ex2FibonacciC(15));
        Thread f4 = new Thread(new Ex2FibonacciD(15));
        f1.start();
        f2.start();
        f3.start();
        f4.start();
    }
}
