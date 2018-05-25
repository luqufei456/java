package com.yiran3.entity1.thinkThread.callableReturn;

import java.util.concurrent.Callable;

/**
 * 从任务中产生返回值
 *
 *    Runnable是执行工作的独立任务，但是它不返回任何值。如果你希望任务在完成时能够返回一个值，
 * 那么可以实现Callable接口而不是Runnable接口。在Java SE5中引入的Callable是一个具有类型参数
 * 的泛型，它的类型参数表示的是从方法call() (而不是run()) 中返回的值，并且必须使用
 * ExecutorService.submit()方法调用它，下面是一个简单示例
 * */

public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call(){
        return "result of TaskWithResult "+id;
    }
}
