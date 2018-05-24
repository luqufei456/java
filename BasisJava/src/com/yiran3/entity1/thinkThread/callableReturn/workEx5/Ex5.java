package com.yiran3.entity1.thinkThread.callableReturn.workEx5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * think in java  Thread习题5
 * */

public class Ex5 {
    public static void main(String[] args){
        // 创建进程池
        ExecutorService execCached = Executors.newCachedThreadPool();

        // 创建ArrayList集合存储submit()方法产生的Future对象
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();

        // 使用for循环创建20个线程，并且传入对应值得到结果
        for (int i = 0;i < 20;i++){
            results.add(execCached.submit(new Ex5Fibonacci(i)));
        }

        // 使用增强for循环遍历取Future对象并使用get方法获取结果
        // 可以发现获取结果是有序的，因为这里是根据循环依次存入。
        for (Future<Integer> fs : results){
            // get()方法获取任务结果
            try {
                System.out.println(fs.get());
            } catch (Exception e){
                e.printStackTrace();
            } finally{
                // 关闭线程池，不可往里添加任务
                execCached.shutdown();
            }

        }
    }
}
