package com.Yiran.Entity;

/**
 *    如果有局部变量名和成员变量名相同，在局部使用的时候，采用的是就近原则。
 *
 *    我们有没有办法把局部变量的name赋值给成员变量的name呢？有
 *
 *    什么办法呢？
 *    	用this关键字就可以解决这个问题。
 *
 *    this:	代表所在类的对象引用
 *    		方法被哪个对象调用，this就代表那个对象
 *
 *    使用场景：	局部变量隐藏成员变量
 * */

public class EncapsulationDefine {
    private String name; // 名字
    private int age; // 年龄

    public void setName(String name){
        // name = name; // 变量'name'被分配给自己 局部变量名和成员变量名相同，使用局部变量名 所以不能直接用 name=name
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age){
        // age = age;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
