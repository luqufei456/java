package com.yiran.entity.encapsulation.employee;

/**
 * 通过private定义的属性或方法，不能通过对象.方法名 or 对象.属性 来访问
 * */

public class EmployeeUse {
    public static void main(String[] args){
        EmployeeEncapsulation person = new EmployeeEncapsulation("yiran",21,0);
        String name = person.name;
        int age = person.age;
        // double salary = person.salary; 无法访问
        person.getSalary();
        // person.show(); 无法访问
    }

}
