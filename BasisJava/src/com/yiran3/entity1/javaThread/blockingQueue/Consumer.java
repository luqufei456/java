package com.yiran3.entity1.javaThread.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> q){
        this.queue = q;
    }

    @Override
    public void run(){
        try {
            String msg;
            while (!"Good Bye!".equalsIgnoreCase((msg = queue.take()))){
                System.out.println("消费商品：" + msg);
                Thread.sleep(5L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
