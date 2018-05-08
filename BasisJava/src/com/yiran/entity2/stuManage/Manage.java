package com.yiran.entity2.stuManage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 管理器，负责界面实现与管理功能
 *
 *    这是我的学生管理系统的主类
 *
 *    步骤如下：
 *    	A：定义学生类
 *    	B：学生管理系统的主界面的代码编写
 *    	C：学生管理系统的查看所有学生的代码编写
 *    	D：学生管理系统的添加学生的代码编写
 *    	E：学生管理系统的删除学生的代码编写
 *    	F：学生管理系统的修改学生的代码编写
 * */

public class Manage {
    public static void main(String[] args){
        // 创建学生集合对象，用于存储学生数据
        ArrayList<Student> stuArr = new ArrayList<Student>();
        // stuArr.add(1); 报错 因为指定了元素类型为Student
        // 创建Manage对象，用于使用方法
        Manage manage = new Manage();

        // 为了让程序能够回到主界面，采取while无限循环
        while (true){
            // 学生管理系统主界面
            System.out.println();
            System.out.println("--------欢迎来到《依然》牌学生信息管理系统--------");
            System.out.println("1 查看所有学生");
            System.out.println("2 添加学生");
            System.out.println("3 删除学生");
            System.out.println("4 修改学生");
            System.out.println("5 退出");
            System.out.println("请输入选择：");

            // 创建键盘录入对象
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine();

            // 使用switch实现选择
            switch (choose){
                case "1":
                    // 查看所有学生
                    manage.findAllStudent(stuArr);
                    break;
                case "2":
                    // 添加学生
                    manage.addStudent(stuArr);
                    break;
                case "3":
                    // 删除学生
                    manage.delStudent(stuArr);
                    break;
                case "4":
                    // 修改学生
                    manage.setStudent(stuArr);
                    break;
                case "5":
                    // 退出
                default:
                    System.out.print("感谢您的使用");
                    System.exit(0); // 退出jvm 即退出程序
                    break;
            }
        }

    }

    public void findAllStudent(ArrayList<Student> stuArr){
        // 首先判断是否有学生
        if (stuArr.size() == 0){
            System.out.println("目前本系统中并没有学生信息，请输入学生信息后在进行查询操作");
            return;
        }
        // \t 即为一个tab的位置
        System.out.println("学号\t姓名\t年龄\t性别\t地址\t");
        for (int x = 0;x < stuArr.size();x++){
            Student stu = stuArr.get(x);
            System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getGender()+"\t"+stu.getAddress());
        }
    }

    public void addStudent(ArrayList<Student> stuArr){
        Scanner sc  = new Scanner(System.in);

        // id定义在循环内部，会无法被访问到 局部变量
        long id;

        while (true){
            // 注意，这里接收字符串不能使用 nextLine() 会被略过
            System.out.print("请输入学号：");
            id = sc.nextLong();
            boolean flag = true;
            for (int x = 0;x < stuArr.size();x++){
                Student stu = stuArr.get(x);
                long thisId = stu.getId();
                if (thisId == id){
                    System.out.println("系统中已存在该学号的学生，请重新输入");
                    flag = false; // 被占用就改为false 如果没被改，后面判断就会退出while循环
                    break;
                }
            }
            if (flag){
                break;
            }
        }

        System.out.print("请输入姓名：");
        String name = sc.next();

        System.out.print("请输入年龄：");
        int age = sc.nextInt();

        System.out.print("请输入性别：");
        String gender = sc.next();

        System.out.print("请输入地址：");
        String address = sc.next();

        // 构造学生对象
        Student stu = new Student(id, name, age, gender, address);

        // 添加学生
        stuArr.add(stu);
    }

    public void delStudent(ArrayList<Student> stuArr){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想要删除的学生学号：");
        long id = sc.nextLong();

        // 因为存的是对象，所以不能使用indexOf方法
        // 首先判断是否有学生
        if (stuArr.size() == 0){
            System.out.println("目前本系统中并没有学生信息，请输入学生信息后在进行查询操作");
            return;
        }
        int re = 0;
        for (int x = 0;x < stuArr.size();x++){
            Student stu = stuArr.get(x);
            long thisId = stu.getId();
            // 字符串使用equals比较
            if (thisId == id){
                stuArr.remove(stu);
                re++;
            }
        }
        if (re == 0){
            System.out.println("系统中并没有符合条件的学生");
            return;
        }
        System.out.println("系统中所有符合该姓名的学生都已删除");
    }

    public void setStudent(ArrayList<Student> stuArr){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想要修改的学生学号：");
        long id = sc.nextLong();

        // 因为存的是对象，所以不能使用indexOf方法
        // 首先判断是否有学生
        if (stuArr.size() == 0){
            System.out.println("目前本系统中并没有学生信息，请输入学生信息后在进行查询操作");
            return;
        }
        int set = 0;
        for (int x = 0;x < stuArr.size();x++){
            Student stu = stuArr.get(x);
            long thisId = stu.getId();
            // 字符串使用equals比较
            if (thisId == id){
                // 获得输入值列
                System.out.print("请输入新学号：");
                long newId = sc.nextLong();

                System.out.print("请输入新名字：");
                String newName = sc.next();

                System.out.print("请输入新年龄：");
                int newAge = sc.nextInt();

                System.out.print("请输入新性别：");
                String newGender = sc.next();

                System.out.print("请输入新地址：");
                String newAddress = sc.next();


                // 更新数据列
                stu.setId(newId);
                stu.setName(newName);
                stu.setAge(newAge);
                stu.setGender(newGender);
                stu.setAddress(newAddress);
                set++;
            }
        }
        if (set == 0){
            System.out.println("系统中并没有符合条件的学生");
            return;
        }
        System.out.println("更新数据完成");
    }

}
