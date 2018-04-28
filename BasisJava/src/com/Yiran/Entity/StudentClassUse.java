package com.Yiran.Entity;

public class StudentClassUse {
    /**
     *  使用一个类，其实就是使用该类的成员。(成员变量和成员方法)
     *  而我们要想使用一个类的成员，就必须首先拥有该类的对象。
     *
     *  我们该如何拥有一个类的对象呢？
     *  创建对象就可以了？
     *
     *  我们如何创建对象呢？
     *  创建对象的格式：
     *      类名 对象名 = new 类名();
     *  对象如何访问成员呢？
     *    	成员变量：对象名.成员变量
     *    	成员方法：对象名.成员方法
     * */
    public static void main(String[] args){
        // 实例化对象
        StudentClassDefine stu = new StudentClassDefine();
        // 定义实例属性
        stu.name = "yiran";
        stu.age = 21;
        stu.gender = false; // 男性
        // 调用实例方法
        stu.study();
        stu.shower();
        // 调用类静态方法
        StudentClassDefine.eat();
    }
}
