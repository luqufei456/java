package com.yiran3.entity2.prepareDemo.jdbcStuManagerSystem;

import java.util.Scanner;

/**
 * jdbc实现的学生管理系统
 * */

public class JdbcStudentsManagerSystem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StudentsManager sm = new StudentsManager();
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("-----JDBC学生信息管理系统-----");
            System.out.println("1、添加学生");
            System.out.println("2、显示所有学生信息");
            System.out.println("3、根据学号显示学员信息");
            System.out.println("4、给学生打分数");
            System.out.println("5、根据学号删除学生");
            System.out.println("6、按学号升序排序，分页显示学生");
            System.out.println("7、退出系统");
            System.out.print("请输入选择：");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("请输入要添加几个学生：");
                    int num = sc.nextInt();
                    for (int i = 0;i < num;i++){
                        System.out.print("请输入学生学号：");
                        String sno = sc.next();
                        System.out.print("请输入学生姓名：");
                        String sname = sc.next();
                        System.out.print("请输入学生年龄：");
                        int age = sc.nextInt();
                        JdbcStudent stu = new JdbcStudent(sno, sname, age, 0);
                        sm.addStudent(stu);
                    }
                    break;
                case 2:
                    sm.showStudents();
                    break;
                case 3:
                    System.out.print("请输入学生学号：");
                    String sno = sc.next();
                    sm.snoShowStu(sno);
                    break;
                case 4:
                    System.out.print("请输入要修改几个学生的成绩：");
                    num = sc.nextInt();
                    for (int i = 0;i < num;i++) {
                        System.out.print("请输入学生学号：");
                        sno = sc.next();
                        System.out.print("请输入学生成绩：");
                        double score = sc.nextDouble();
                        sm.setScore(sno, score);
                    }
                    break;
                case 5:
                    System.out.print("请输入要删除的学生学号：");
                    sno = sc.next();
                    sm.delStu(sno);
                    break;
                case 6:
                    System.out.print("请输入每页显示多少名学生：");
                    int pageSize = sc.nextInt();
                    System.out.print("请输入显示第多少页的学生：");
                    int pageNum = sc.nextInt();
                    sm.showPageStu(pageSize, pageNum);
                    break;
                case 7:
                    sm.close();
                    return;
                default:
                    System.out.println("请输入正确的选项");
                    break;
            }
        }
    }
}
