package com.yiran3.entity1.javaThread.jdkUtils.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreWorker implements Runnable {

    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run(){
        try {
            semaphore.acquire();
            System.out.println("执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
