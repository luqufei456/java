package com.yiran3.entity1.javaThread.jdkUtils.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class LatchSample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5); // 初始化计数
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new FirstBatchWorker(latch));
            t.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SecondBatchWorker(latch));
            t.start();
        }

        // 获取剩余计数
        /*while (latch.getCount() != 1) {
            Thread.sleep(100L);
        }*/
        //System.out.println("等待第一批完成");
        //latch.countDown(); // 此时计数为0了，第二批可以开始运行
    }
}
