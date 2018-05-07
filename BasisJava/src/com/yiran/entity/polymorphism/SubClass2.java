package com.yiran.entity.polymorphism;

public class SubClass2 extends SuperClass {
    int level = 20;


    public static void staFunction(){
        System.out.println("这是蠢觉的静态方法，覆盖了超类的静态方法");
    }

    public void getLevel(){
        System.out.println(this.level);
        System.out.println("我跟你说，这是蠢觉的方法");
    }

    public void function(){
        System.out.println("这是蠢觉的成员方法");
    }

    // 定义新的方法--扩展接口
    public void studyMath(){
        System.out.println("蠢觉会学习数学");
    }

    public SubClass2(){}

    public SubClass2(String name){
        super(name);
    }

    public SubClass2(String name, int age){
        super(name, age);
    }

    public SubClass2(String name, boolean gender){
        super(name, gender);
    }

    public SubClass2(String name, int age, boolean gender){
        super(name, age, gender);
    }

}
