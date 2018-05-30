package com.yiran3.entity1.properties.testDemo1;

/**
 * 老师类，用于实例反射和Properties
 * */

public class ProTeacher {
    private int id;
    private String name;

    public ProTeacher(int id, String name){
        this.id = id;
        this.name = name;
    }

    public ProTeacher(){}

    @Override
    public String toString(){
        return "Student [ id="+id+", name="+name+" ]";
    }
}
