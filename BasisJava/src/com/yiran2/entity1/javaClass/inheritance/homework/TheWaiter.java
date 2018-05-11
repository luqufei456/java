package com.yiran2.entity1.javaClass.inheritance.homework;

/**
 * 服务员类
 * 工作方法：“上菜与结账”
 * */

public class TheWaiter extends TheEmployee {
    public TheWaiter(){
        System.out.println("调用服务员类无参构造方法");
    }

    public TheWaiter(String name, double salary){
        super(name, salary);
        System.out.println("调用服务员类有参构造方法");
    }

    @Override
    public void work(){
        System.out.println("服务员"+this.getName()+"：上菜与结账");
    }
}
