package com.yiran3.entity1.javaThread.jdkUtils.semaphore;

import java.util.concurrent.Semaphore;

public class UsualSemaphoreSample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SemaphoreWorker(semaphore));
            t.start();
        }
        System.out.println("开始");
        semaphore.release(5);
        System.out.println("等待许可");
        while (semaphore.availablePermits() != 0) {
            Thread.sleep(100L);
        }
        System.out.println("再次开始");
        semaphore.release(5);
    }
}
