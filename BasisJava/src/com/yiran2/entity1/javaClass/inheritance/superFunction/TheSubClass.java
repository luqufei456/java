package com.yiran2.entity1.javaClass.inheritance.superFunction;

/**
 * 子类
 * */

public class TheSubClass extends TheSuperClass {
    public TheSubClass(){
        super(); // 这个super语句决定了子类构造方法调用父类空参构造
        System.out.println("子类的无参构造方法被调用了");
    }

    public TheSubClass(String name){
        super(name); // 这个super语句决定了子类构造方法调用父类有参构造
        System.out.println("子类的有参构造方法被调用了");
    }

    /*public TheSuperClass(){ // 也可以使用this来调用子类自身的构造方法 但是不常用
        this("baka");
    }
*/
}
