package com.yiran.entity.encapsulation.employee;

/**
 * 封装就是把类的属性和操作封装在一起，数据被保护到内部，
 * 程序的其它部分只有通过被授权的操作(成员方法)，才能对数据进行操作
 *
 * 封装是通过访问修饰符来控制的
 * 访问修饰符有四种：public   protected   无   private
 *      1、公开级别：用public 修饰，对外公开
 *      2、受保护级别：用protected修饰，对子类和同一个包中的类公开
 *      3、默认级别：没有修饰符，向同一个包的类公开
 *      4、私有级别：用private修饰，只有类本身可以访问，不对外公开
 *
 * 默认级别  子类无法访问前提是子类与父类不在同一个包下，
 * */

public class EmployeeEncapsulation {
    // 定义成员变量，控制访问级别
    public String name;
    public int age;
    private double salary;

    // 定义构造方法
    public EmployeeEncapsulation(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void getSalary(){
        System.out.println(name+"今年"+age+"岁，薪水为"+salary+"元");
    }

    private void show(){
        System.out.println("私有方法只有本类才能访问，在类外无法访问");
    }

}
