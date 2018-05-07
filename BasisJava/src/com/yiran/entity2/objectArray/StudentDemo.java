package com.yiran.entity2.objectArray;

public class StudentDemo {
    public static void main(String[] args){
        // 创建学生数组
        Student[] students = new Student[3];

        // 创建学生对象
        Student yiran = new Student("yiran",21);
        Student chunjue = new Student("chunjue",25);
        Student baba = new Student("baba",23);

        // 把学生对象作为元素赋值给学生数组
        students[0] = yiran;
        students[1] = chunjue;
        students[2] = baba;

        for (int x = 0;x < students.length;x++){
            Student stu = students[x];
            System.out.println("地址为："+stu);
            stu.show();
        }

    }

}
