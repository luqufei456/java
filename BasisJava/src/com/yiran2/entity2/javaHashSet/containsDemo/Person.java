package com.yiran2.entity2.javaHashSet.containsDemo;

import java.util.Vector;

/**
 * 重写equals方法，从比较对象的地址重写为比较对象的内容
 * 重写hashcode方法。
 * */

public class Person {
    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 如果没有重写该equals方法,则比较地址值.
     * 我们希望比较两个对象时,比较属性内容,所以重写该方法.
     */
    @Override
    public boolean equals(Object obj){
        System.out.println("重写的equals方法被调用");
        // 将obj强转为Person类型
        Person p = (Person)obj;

        // 比较姓名
        if (!this.name.equals(p.name)){
            return false;
        }
        // 比较年龄
        if (this.age != p.age){
            return false;
        }
        // 当所有属性都相同，返回true
        return true;
    }

    /**
     * 没有重写hashCode方法时,hashCode方法继承父类方法,返回的是地址值
     * 重写hashCode方法,通过属性值返回一个整数数字
     * 即对象的hashCode值,就是各个属性的hashCode值之和
     * 引用数据类型属性,调用hashCode方法回去
     * 基本数值类型属性,直接就是数值本身
     */
    @Override
    public int hashCode() {
        //张三   18   >>   56*系数  +  18  = 74
        //李四   56   >>   18*系数  +  56  = 74
        //理想上,不同属性值应该返回不同的hashCode值,可以在每次结果后乘以一个固定系数,避免该情况发生

        //定义变量,记录要返回的hashCode值
        int thisHashCode = 0;

        //获取name属性的hashCode值 这里定义系数为17
        thisHashCode += name.hashCode()*17;
        //获取age数只给你的hashCode值
        thisHashCode += age;

        return thisHashCode;
    }
}
