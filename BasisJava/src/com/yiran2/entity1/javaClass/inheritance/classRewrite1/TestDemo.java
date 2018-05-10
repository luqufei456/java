package com.yiran2.entity1.javaClass.inheritance.classRewrite1;

/**
 * 覆盖和重写的测试类
 *
 * 方法重写:
 * 		当子类想加强父类继承过来的方法时,可以重写该方法
 *
 * 重写格式:
 * 		定义一个与父类方法声明完全相同的方法,方法体重写
 *
 * 成员变量覆盖：
 *      定义一个与父类声明完全相同的成员变量~
 *
 * 静态方法覆盖:
 *      定义一个与父类方法名相同的静态方法即可，由于静态方法与类有关，所以并不是重写，而是将父类的静态方法隐藏了
 *      也称之为覆盖
 * */

public class TestDemo {
    public static void main(String[] args){
        // 创建子类对象
        Dog paojie = new Dog();
        // 使用子类输出name属性 发现父类的属性也被子类屏蔽
        System.out.println(paojie.name);
        // 调用重写的eat方法
        paojie.eat();
        // 调用未重写的sleep方法
        paojie.sleep();
        // 调用覆盖的静态方法
        paojie.staticFunction();
    }
}
