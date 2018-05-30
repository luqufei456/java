package com.yiran3.entity1.properties.testDemo1;

/**
 * 学生类，用于实例反射和Properties
 * */

public class ProStudent {
    private int id;
    private String name;

    public ProStudent(int id, String name){
        this.id = id;
        this.name = name;
    }

    public ProStudent(){}

    @Override
    public String toString(){
        return "Student [ id="+id+", name="+name+" ]";
    }
}
