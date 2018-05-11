package com.yiran2.entity1.javaClass.inheritance.superFunction;

/**
 * 父类
 * */

public class TheSuperClass {
    private String name;

    public TheSuperClass(){
        System.out.println("父类的无参构造方法被调用");
    }

    public TheSuperClass(String name ){
        this.name = name;
        System.out.println("父类的有参构造方法被调用");
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}