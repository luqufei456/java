package com.Yiran.Entity.ClassReturn;

public class Test {
    // 如果方法的返回值是类名：其实返回的是该类的对象
    public static void main(String[] args){
        Teacher t = new Teacher();
        Student s = t.getStudent();
        s.study();
    }
}
