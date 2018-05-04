package com.yiran.entity.javaStatic;

/**
 * 静态变量是该类所有对象共享的变量，任何一个该类的对象去访问它时，取到的都是相同的值，
 * 同样任何一个该类的对象去修改它时，修改的也是同一个变量。
 *
 * 使用：
 *     1、如何定义静态变量
 *      访问修饰符  static  数据类型  变量名
 *     2、如何访问静态变量
 *     类名.静态变量名(有权限限制)     或者     对象名. 静态变量名
 * */

public class StaticVariable {
    String name;
    int age;
    boolean gender;
    private static int stuCount;

    public StaticVariable(){
        stuCount++;
    }

    public StaticVariable(String name){
        this.name = name;
        stuCount++;
    }

    public StaticVariable(String name, int age){
        this.name = name;
        this.age = age;
        stuCount++;
    }

    public StaticVariable(String name, boolean gender){
        this.name = name;
        this.gender = gender;
        stuCount++;
    }

    public StaticVariable(String name, int age, boolean gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
        stuCount++;
    }

    public void show(){
        System.out.println(name+"今年"+age+"岁，性别为"+gender);
    }

    public void stuCount(){
        System.out.println("当前总共有"+stuCount+"名学生");
    }

}

class Variable{
    public static void main(String[] args){
        StaticVariable s1 = new StaticVariable();
        s1.name = "yiran";
        s1.show();
        s1.stuCount();

        StaticVariable s2 = new StaticVariable("Chunjue",25);
        s2.show();

        StaticVariable s3 = new StaticVariable("Miku");
        s3.show();
        s3.stuCount();

        // System.out.println(s1.stuCount); // 使用实例访问静态变量
        // System.out.println(StaticVariable.stuCount); // 使用类访问静态变量
        // 用 private设置为私有后，只能在类的内部使用，在外部即使是用 类名.变量名 也无法使用

    }
}