package com.yiran3.entity1.javaThread.threadPool;

import java.util.concurrent.Callable;

/**
 * 我的Callable实现类
 *
 * 定义线程执行目标
 * */

public class MyCallable1 implements Callable<String>{
    @Override
    public String call(){
        return "这个call会返回值，存储在Future中";
    }
}
