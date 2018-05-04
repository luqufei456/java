package com.yiran.entity;

public class EncapsulationUse {
    public static void main(String[] args){
        EncapsulationDefine stu = new EncapsulationDefine();
        System.out.println(stu.getName()+"------"+stu.getAge());

        stu.setName("yiran");
        stu.setAge(21);
        System.out.println(stu.getName()+"------"+stu.getAge());

        // 如果Define中使用 name=name  age=age 则输出都为 null------0
        // 相当于局部变量赋值给自己，而不是赋值给成员变量
    }
}
