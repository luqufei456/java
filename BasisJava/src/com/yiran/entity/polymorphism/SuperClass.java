package com.yiran.entity.polymorphism;

/**
 *  多态成员访问的特点：
 *
 *  成员变量：
 *      编译看左边(父类),运行看左边(父类)
 *    但是子类使用父类构造方法以后，值都是一样的，所以自己定义不在构造方法中的变量 更容易理解
 *  成员方法：
 *      编译看左边(父类)，运行看右边(子类)。动态绑定
 *    编译看左边意思就是，父类没有该名字的方法 就无法编译 报错 但是运行是运行的子类的同名方法
 *  静态方法：
 *      编译看左边(父类)，运行看左边(父类)。
 *      (静态和类相关，算不上重写，只能算覆盖。所以，访问还是左边的)
 *
 *  只有非静态的成员方法,编译看左边,运行看右边
 *
 *  向上转型：
 *      将导出类看做为它的基类  基类 name = new 子类();
 *  向下转型：
 *      子类 name1 = (子类)name; 一般不会用
 * */

public class SuperClass {
    String name;
    int age;
    boolean gender;
    int level = 100;

    public SuperClass(){System.out.println("调用了一个无参构造方法");}

    public SuperClass(String name){
        this.name = name;
        System.out.println("调用了一个单参构造方法");
    }

    public SuperClass(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("调用了一个双参构造方法");
    }

    public SuperClass(String name, boolean gender){
        this.name = name;
        this.gender = gender;
        System.out.println("调用了一个双参构造方法");
    }

    public SuperClass(String name, int age, boolean gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
        System.out.println("调用了一个三参构造方法");
    }

    public static void staFunction(){
        System.out.println("这是一个静态方法，只能被覆盖，无法被重写");
    }

    public void getLevel(){
        System.out.println(this.level);
        System.out.println("我跟你说，这是超类的方法");
    }

    public void function(){
        System.out.println("这是超类的一个普通的成员方法");
    }

}
