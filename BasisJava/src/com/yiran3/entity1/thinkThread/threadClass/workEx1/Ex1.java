package com.yiran3.entity1.thinkThread.threadClass.workEx1;

/**
 * think in java  Thread习题1
 * */

public class Ex1 {
    public static void main(String[] args){
        // 创建三个线程，并分别分配任务
        Thread ta = new Thread(new Ex1RunnerA());
        Thread tb = new Thread(new Ex1RunnerB());
        Thread tc = new Thread(new Ex1RunnerC());

        // 开始线程
        ta.start();
        tb.start();
        tc.start();
    }
}
