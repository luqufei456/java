package com.yiran2.entity2.javaRecursion;

/**
 * 方法递归
 *
 *     递归算法: 方法自身调用方法自身,必须有方法出口(可以结束方法的条件),
 *  递归次数不宜过多,会有stackoverflow(栈内存溢出)
 * */

public class RecursionDemo2 {
    // 定义静态成员变量，供不同的方法访问
    static private int i = 1;

    public static void main(String[] args){
        RecursionDemo2 admin = new RecursionDemo2();
        admin.method();
    }

    // 定义一个调用自己的递归方法
    private void method(){
        System.out.println("方法开始："+i);

        // 定义一个方法出口
        if (i == 4){
            return;
        }
        i++;
        method();
    }
}
