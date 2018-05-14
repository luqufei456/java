package com.yiran2.entity1.javaClass.nestedClass;

/**
 * 成员内部类测试类
 *
 *    内部类是一个相对概念，即类中定义类
 *    内部类可以直接访问外部类的所有成员
 *
 *    内部类：
 *    	成员内部类：定义在成员位置
 *    	局部内部类：定义在局部位置，即一个方法内
 *
 *    成员内部类创建对象，必须有外部类对象，才能有内部类对象
 *    Outer.Inner  x = new Outer().new Inner();
 * */

public class NestedClassDemo1 {
    public static void main(String[] args){
        // 创建成员内部类对象
        NestedClass1.InnerClass inner = new NestedClass1().new InnerClass();
        inner.innerMethod();
    }
}
