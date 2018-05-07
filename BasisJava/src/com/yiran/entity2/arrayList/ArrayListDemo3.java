package com.yiran.entity2.arrayList;

/**
 * 创建一个Student类包含姓名和年龄属性
 * 创建一个ArrayList集合
 * 向集合中添加三个Student对象Student对象中姓名和年龄的数据均来自与键盘录入
 * 最终遍历这个集合,取出Student对象以及里面属性的值
 *
 * 创建一个集合，存储学生对象，学生对象的数据来自于键盘录入，最后，遍历集合
 *
 * 分析：
 * 		A:定义学生类
 * 		B:创建集合对象
 * 		C:键盘录入数据,创建学生对象,把键盘录入的数据赋值给学生对象的成员变量
 * 		D:把学生对象作为元素存储到集合中
 * 		E:遍历集合
 * */

import com.yiran.entity2.objectArray.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo3 {
    public static void main(String[] args){
        ArrayList<Student> stuArr = new ArrayList<Student>();

        ArrayListDemo3 arrayListDemo3 = new ArrayListDemo3();
        arrayListDemo3.addNum(stuArr);
        // 遍历
        arrayListDemo3.traverse(stuArr);
    }

    public void addNum(ArrayList<Student> stuArr){
        // 键盘录入数据，根据录入的数字来决定创建几个学生对象
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想要插入的学生数量：");
        int num = sc.nextInt();
        for (int x = 0;x < num;x++){
            addStudent(stuArr);
        }
    }

    public void addStudent(ArrayList<Student> stuarr){
        // 键盘录入数据，创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.print("请输入学生年龄：");
        int age = sc.nextInt();

        Student stu = new Student(name, age);
        // 添加学生对象
        stuarr.add(stu);
    }

    public void traverse(ArrayList<Student> stuArr){
        for (int x = 0;x < stuArr.size();x++){
            Student stu = stuArr.get(x);
            stu.show();
        }
    }

}
