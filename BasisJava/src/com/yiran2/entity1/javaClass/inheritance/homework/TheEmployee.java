package com.yiran2.entity1.javaClass.inheritance.homework;

/**
 * 父类员工类
 *
 * 定义父类员工类:
 * 	员工姓名,员工薪水,员工工作方法
 * */

public class TheEmployee {
    // 姓名
    private String name;
    // 薪水
    private double salary;

    // 员工工作方法
    public void work(){
        System.out.println("work");
    }

    public TheEmployee(){
        System.out.println("调用员工类无参构造方法");
    }

    public TheEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        System.out.println("调用员工类有参构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
