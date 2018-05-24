package com.yiran3.entity1.thinkThread.callableReturn;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *    submit()方法会产生Future对象，它用Callable返回结果的特定类型进行了参数化。你可以用
 * isDone()方法来查询Future是否已经完成。当任务完成时，它具有一个结果，你可以调用get()方法
 * 来获取该结果。你也可以不用isDone()进行检查就直接调用get()，在这种情况下，get()将阻塞，
 * 直到结果准备就绪。你还可以在试图调用get()来获取结果之前，先调用具有超时的get()，或者调用
 * isDone()来查看任务是否完成。
 * */

public class CallableDemo {
    public static void main(String[] args){
        // 创建CachedThreadPool执行器对象
        ExecutorService execCached = Executors.newCachedThreadPool();

        // 创建一个ArrayList集合存储返回值
        // 调用submit()方法会返回一个Future对象，它用Callable返回结果的特定类型进行了参数化
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();

        // 使用for循环创建10个进程，并调用submit()方法，将其返回对象添加到集合中
        for (int i = 0;i < 10;i++){
            results.add(execCached.submit(new TaskWithResult(i)));
        }

        // 使用加强for循环取出对象，使用get方法获取其结果
        for (Future<String> fs : results){
            // get()方法获取任务结果
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e){
                e.printStackTrace();
            } catch (ExecutionException e){
                e.printStackTrace();
            } finally{
                // 关闭线程池，不可往里添加任务
                execCached.shutdown();
            }

        }
    }
}
