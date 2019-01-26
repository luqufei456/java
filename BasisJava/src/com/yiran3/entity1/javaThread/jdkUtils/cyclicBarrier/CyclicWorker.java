package com.yiran3.entity1.javaThread.jdkUtils.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicWorker implements Runnable {
    private CyclicBarrier barrier;

    public CyclicWorker(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++){
                System.out.println("执行");
                barrier.await();
            }
        } catch (BrokenBarrierException | InterruptedException e){
                e.printStackTrace();
        }
    }
}
