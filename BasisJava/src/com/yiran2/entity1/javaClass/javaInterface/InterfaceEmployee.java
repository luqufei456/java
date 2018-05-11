package com.yiran2.entity1.javaClass.javaInterface;

/**
 * 抽象的父类Employee员工类
 * */

public abstract class InterfaceEmployee {
    private String name;

    public InterfaceEmployee(){
        System.out.println("抽象父类员工类的无参构造方法");
    }

    public InterfaceEmployee(String name){
        this.name = name;
        System.out.println("抽象父类员工类的有参构造方法");
    }

    // 抽象方法
    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
