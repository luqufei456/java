package com.yiran2.entity1.twoModified.staticDemo;

/**
 * Chinese中国人类
 *
 * 中国人类
 * 	国籍,姓名,年龄,职业
 * 	其中,国籍应该被共享
 * 	姓名,年龄,职业各个对象有各个对象的值
 * */

public class Chinese {
    // 静态成员，被多个对象共享
    public static String country = "中国";

    // 普通成员，每个对象独有的普通成员 不共享
    private String name;
    private int age;
    private String work;

    public Chinese(){}

    public Chinese(String name, int age, String work){
        this.name = name;
        this.age = age;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
