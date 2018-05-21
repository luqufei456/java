package com.yiran2.entity2.javaRecursion;

/**
 * 递归求阶乘
 *
 * 递归可以将复杂问题简单化
 *
 *  求N的阶乘,以5的阶乘为例
 *  5*4*3*2*1
 *
 *  5! = 5 * 4!;
 *  			4! = 4 * 3!;
 *  					 3! = 3 * 2!;
 *  							  2!= 2 * 1!;
 *  									  1! = 1;  单独唯一的逻辑
 *
 *  递归逻辑:
 *  		当前这个数 * (比当前这个数-1)的阶乘
 *  递归出口:
 *  		如果求到了1的阶乘,就直接返回1,不再求阶乘了
 * */

public class RecursionTest1 {
    public static void main(String[] args){
        int result = new RecursionTest1().method(5);
        System.out.println("5! = "+result);
    }

    public int method(int n){
        // 方法出口，如果是求1的阶层，直接返回1
        if (n == 1){
            return 1;
        }
        return n * method(n-1);
    }
}
