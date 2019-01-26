package com.yiran3.entity1.javaThread.jdkUtils.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {
    public static void main(String[] args) {
        // 参数parties指让多少个线程或者任务等待至barrier状态；参数barrierAction为当这些线程都达到barrier状态时会执行的内容。
        // 这里是 5 个任务等待到 barrier状态，然后执行run方法输出 再次执行
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("再次执行");
            }
        });

        for (int i = 0; i < 5; i++) {
            // worker 中定义的for循环，决定了 "再次执行" 输出几次
            // await 等待计数归零，可以这么认为
            Thread t = new Thread(new CyclicWorker(barrier));
            t.start();
        }
    }
}
