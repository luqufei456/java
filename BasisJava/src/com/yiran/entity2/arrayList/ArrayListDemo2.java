package com.yiran.entity2.arrayList;

/**
 *    A:自定义一个学生类,学生中有姓名和年龄属性,生成满参构造与空参构造
 *  生成属性对应的getter/setter方法
 *    B:在测试类中使用满参构造创建三个学生对象,然后将每个学生对象均添加到ArrayList集合中
 *    C:遍历这个ArrayList集合,依次打印出每个学生的姓名和年龄
 * */

import com.yiran.entity2.objectArray.Student;

import java.util.ArrayList;

public class ArrayListDemo2 {
    public static void main(String[] args){
        // 构造学生对象
        Student yiran = new Student("依然",21);
        Student junnan = new Student("陈君男",21);
        Student baba = new Student("粑粑",23);
        Student gel = new Student("鸽l",23);
        Student paojie = new Student("炮姐",22);

        // 定义集合
        ArrayList<Student> stuArr = new ArrayList<Student>();

        // 将学生对象加入集合
        stuArr.add(yiran);
        stuArr.add(junnan);
        stuArr.add(baba);
        stuArr.add(gel);
        stuArr.add(paojie);
        System.out.println(stuArr);

        for (int x = 0;x < stuArr.size();x++){
            Student stu = stuArr.get(x);
            stu.show();
        }

    }
}
