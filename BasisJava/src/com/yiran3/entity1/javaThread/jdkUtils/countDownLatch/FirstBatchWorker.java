package com.yiran3.entity1.javaThread.jdkUtils.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class FirstBatchWorker implements Runnable {
    private CountDownLatch latch;

    public FirstBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("第一批执行！");
        latch.countDown(); // 计数-1
    }
}
