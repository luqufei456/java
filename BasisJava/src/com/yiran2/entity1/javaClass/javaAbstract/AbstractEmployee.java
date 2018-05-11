package com.yiran2.entity1.javaClass.javaAbstract;

/**
 * 抽象的父类Employee员工类
 *
 * 该构造方法,不能直接被程序员调用,因为该类为抽象类,不能直接创建对象.
 * 但是在创建子类对象时,子类的构造方法,可以调用父类的构造方法,为子类对象中的父类存储空间赋值
 * */

public abstract class AbstractEmployee {
    private String name;

    public abstract void work();

    //该构造方法,不能直接被程序员调用,因为该类为抽象类,不能直接创建对象.
    //但是在创建子类对象时,子类的构造方法,可以调用父类的构造方法,为子类对象中的父类存储空间赋值
    public AbstractEmployee(){
        System.out.println("我是抽象员工类的无参构造方法");
    }

    public AbstractEmployee(String name){
        this.name = name;
        System.out.println("我是抽象员工类的有参构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
