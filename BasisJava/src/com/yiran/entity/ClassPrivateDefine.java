package com.yiran.entity;

public class ClassPrivateDefine {
    /**
     * 是一个权限修饰符。(其他的权限修饰符:private  default   protected    public)
     * 可以修饰成员(成员变量和成员方法)
     * 被private修饰的成员只在本类中才能访问。
     * */
    String name; // 姓名
    private int age; // 年龄

    public void setAge(int a){
        if (a < 0 || a > 200){
            System.out.println("你给的年龄有误");
        }
        else{
            age = a;
        }
    }

    public int getAge(){
        return age;
    }

    public void show(){
        System.out.println("姓名是："+ name + "，年龄是：" + age);
    }

}
