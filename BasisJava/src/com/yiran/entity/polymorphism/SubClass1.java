package com.yiran.entity.polymorphism;

public class SubClass1 extends SuperClass {
    int level = 10;


    // 覆盖父类静态方法
    public static void staFunction(){
        System.out.println("这是依然的静态方法，覆盖了超类的静态方法");
    }

    public void getLevel(){
        System.out.println(this.level);
        System.out.println("我跟你说，这是依然的方法");
    }

    // 重写父类成员方法
    public void function(){
        System.out.println("这是依然的成员方法");
    }

    // 定义新的方法--扩展接口
    public void playDNF(){
        System.out.println("依然喜欢玩DNF");
    }

    public SubClass1(){}

    public SubClass1(String name){
        super(name);
    }

    public SubClass1(String name, int age){
        super(name, age);
    }

    public SubClass1(String name, boolean gender){
        super(name, gender);
    }

    public SubClass1(String name, int age, boolean gender){
        super(name, age, gender);
    }

}
