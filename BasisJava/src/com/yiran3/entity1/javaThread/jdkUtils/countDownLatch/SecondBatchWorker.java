package com.yiran3.entity1.javaThread.jdkUtils.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class SecondBatchWorker implements Runnable {
    private CountDownLatch latch;

    public SecondBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await(); // 等待计数减至0。
            System.out.println("第二批执行！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
