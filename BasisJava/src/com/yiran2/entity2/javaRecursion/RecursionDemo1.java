package com.yiran2.entity2.javaRecursion;

/**
 * 方法递归基础
 *
 * 	不同的方法之间可以相互调用,即A方法可以将B方法调用,内存当中就多了一个B方法,B方法结束,A继续执行
 * */

public class RecursionDemo1 {
    // 定义静态成员变量，供不同的方法访问
    static private int i = 1;

    public static void main(String[] args){
        RecursionDemo1 admin = new RecursionDemo1();
        admin.methodA();
    }

    /**
     * @Title: methodA
     * @Description: 第一个方法：打印i,i++,再调用其他方法,i++,打印
     */
    private void methodA(){
        System.out.println("方法A："+i);
        i++;
        methodB();
        i++;
        System.out.println("方法A："+i);
    }

    /**
     * @Title: methodB
     * @Description: 第二个方法
     */
    private void methodB(){
        System.out.println("方法B："+i);
        i++;
        methodC();
        i++;
        System.out.println("方法B："+i);
    }

    private void methodC(){
        System.out.println("方法C："+i);
        i++;
        methodD();
        i++;
        System.out.println("方法C："+i);
    }

    private void methodD(){
        System.out.println("方法D："+i);
    }
}
