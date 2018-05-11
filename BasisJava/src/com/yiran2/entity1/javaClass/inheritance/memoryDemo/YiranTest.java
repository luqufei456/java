package com.yiran2.entity1.javaClass.inheritance.memoryDemo;

/**
 * 继承测试类
 *
 * this:当前对象
 * super:父类存储空间
 *
 * Person父类
 * 	name,age
 *
 * Chinese子类
 *  	address
 *
 *  结论：
 *      this和super的哈希code相同，两者值相同，说明在同一片内存地址
 * */

public class YiranTest {
    public static void main(String[] args){
        // 使用无参构造方法修饰对象
        TheYiran yiran = new TheYiran();

        // 使用有参构造方法修饰对象
        TheYiran Yiran = new TheYiran("依然",21,"武汉");

    }
}
