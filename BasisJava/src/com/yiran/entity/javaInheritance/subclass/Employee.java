package com.yiran.entity.javaInheritance.subclass;

import com.yiran.entity.javaInheritance.superclass.PersonClass;

public class Employee extends PersonClass {
    private String like;

    String thisname = super.name; // 在不同包 只能通过super访问 protected和public修饰的变量
    int thisage = super.age;

    public static void main(String[] args){
        Employee chunjue = new Employee("chunjue",true,25,25000);

        // public 公开访问类型
        String name = chunjue.name;

        // 默认访问权限
        // boolean gender = chunjue.gender;

        // protected 保护访问类型
        int age = chunjue.age;

        // private 私有访问类型
        // double salary = chunjue.salary;

        chunjue.show();

        // 调用父类静态方法 后面覆盖了父类的静态方法，所以这里是子类的
        ena();

        // 无法调用父类 private方法
        // chunjue.haha();

        chunjue.setLike("sc");

    }

    // 重写方法 重写  不是重载
    public void showtime(){
        System.out.println("现在是属于"+name+"的时间，呀吼吼");
    }

    // 重写父类静态方法
    public static void ena(){
        System.out.println("这是专属于chunjue的静态方法");
    }

    // 声明新的方法
    public void setLike(String like){
        this.like = like;
        System.out.println(name+"最喜欢的是"+like);
        // 访问父类的方法
        super.showtime();
        // 访问自己重写的方法
        showtime();
    }

    public Employee(){}

    // 显式调用父类构造方法，对父类进行初始化。
    // 注意: 子类调用父类的构造方法时，super语句必须是子类构造方法的第一句
    public Employee(String name, boolean gender, int age, double salary){
        super(name,gender,age,salary);
        // 下面这些都不需要写，直接使用父类的构造方法赋值好了
        // this.name = name;
        // this.gender = gender;
        // this.age = age;
    }

}
