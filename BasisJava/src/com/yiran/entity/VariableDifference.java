package com.yiran.entity;

public class VariableDifference {
    /**
     *    成员变量和局部变量的区别
     *    	A：在类中的位置不同
     *    		成员变量： 类中方法外
     *    		局部变量： 方法内或者方法声明上(形式参数)
     *    	B：在内存中的位置不同
     *    		成员变量： 堆内存
     *    		局部变量： 栈内存
     *    	C：生命周期不同
     *    		成员变量： 随着对象的存在而存在，随着对象的消失而消失
     *    		局部变量： 随着方法的调用而存在，随着方法的调用完毕而消失
     *		D：初始化值不同
     *			成员变量： 有默认的初始化值
     *			局部变量： 没有默认的初始化值，必须先定义，赋值，才能使用。
     * */
    // 成员变量
    int x;

    public void show(){
        // 局部变量
        int y = 0;
        System.out.println(x);
        System.out.println(y);
    }
}
