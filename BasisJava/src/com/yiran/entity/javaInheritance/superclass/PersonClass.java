package com.yiran.entity.javaInheritance.superclass;

public class PersonClass {
    public String name;
    boolean gender;
    protected int age ;
    private double salary;

    public PersonClass(){
        System.out.println("人类构造函数执行ing---无参版");
    }

    public PersonClass(String name, boolean gender, int age, double salary){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        System.out.println("人类构造函数执行ing---完全版");
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGender(boolean gender){
        this.gender = gender;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public void show(){
        System.out.println(name+"性别"+gender+",今年"+age+"岁,每个月工资为"+salary);
    }

    public void showtime(){
        System.out.println("现在是属于"+name+"的时间");
    }

    private void haha(){
        System.out.println("hahahaha");
    }

    public static void ena(){
        System.out.println("这是一个静态方法");
    }

}
