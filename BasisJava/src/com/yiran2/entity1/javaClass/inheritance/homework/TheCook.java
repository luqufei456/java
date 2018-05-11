package com.yiran2.entity1.javaClass.inheritance.homework;

/**
 *
 * */

public class TheCook extends TheEmployee{
    public TheCook(){
        System.out.println("调用厨师类无参构造方法");
    }

    public TheCook(String name, double salary){
        super(name, salary);
        System.out.println("调用厨师类有参构造方法");
    }

    public void work(){
        System.out.println("厨师"+this.getName()+"：做菜");
    }
}
