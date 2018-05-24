package com.yiran3.entity1.thinkThread.callableReturn.workEx5;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 修改练习2
 * 将计算所有斐波那契数字的数值总和的任务成为Callable。创建多个任务并返回结果
 * */

public class Ex5Fibonacci implements Callable<Integer> {
    private int n = 0;

    public Ex5Fibonacci(int n){
        this.n = n;
    }

    private int fib(int x){
        if (x < 2) return 1;
        return fib(x - 2) + fib(x -1);
    }

    public Integer call(){
        int result = 0;
        for (int i = 0;i < n;i++){
            result += fib(i);
        }
        // 其实这里自动隐式转换了
        return (Integer) result;
    }
}
