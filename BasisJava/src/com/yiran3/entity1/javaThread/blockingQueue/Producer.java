package com.yiran3.entity1.javaThread.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            try {
                Thread.sleep(10L);
                String msg = "Message" + i;
                System.out.println("生产者新产品：" + msg);
                queue.put(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("生产完毕");
            queue.put("Good Bye!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
