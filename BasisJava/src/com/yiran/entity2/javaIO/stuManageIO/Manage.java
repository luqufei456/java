package com.yiran.entity2.javaIO.stuManageIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    public static void main(String[] args) throws IOException{
        // 创建学生集合对象，用于存储学生数据
        ArrayList<Student> stuArr = new ArrayList<Student>();
        // 创建Manage对象，用于使用方法
        Manage manage = new Manage();

        // 定义文件路径
        String filePath = "src\\com\\yiran\\entity2\\javaIO\\staticFile\\student.txt";

        System.out.println("--------欢迎来到《依然》牌学生信息管理系统--------");
        // 为了让程序能够回到这里来，我们使用循环
        while (true){
            System.out.println();
            System.out.println("1 查看所有学生");
            System.out.println("2 添加学生");
            System.out.println("3 删除学生");
            System.out.println("4 修改学生");
            System.out.println("5 退出");
            System.out.print("请输入选择：");
            // 创建键盘录入对象
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine();

            // 用switch语句实现选择
            switch (choose){
                case "1":
                    // 查看所有学生
                    manage.findAllStudent(filePath, stuArr);
                    break;
                case "2":
                    // 添加学生
                    manage.addStudent(filePath, stuArr);
                    break;
                case "3":
                    // 删除学生
                    manage.delStudent(filePath, stuArr);
                    break;
                case "4":
                    // 修改学生
                    manage.setStudent(filePath,stuArr);
                    break;
                case "5":
                    // 退出
                default:
                    System.out.print("感谢您的使用");
                    System.exit(0);
                    break;
            }
        }
    }

    public void readAllFile(String filePath, ArrayList<Student> stuArr) throws IOException{
        // 清空集合 每次读文件之前，都将集合清空 免得数据重复
        stuArr.clear();
        // 创建输入缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = br.readLine()) != null){
            String[] strArr = line.split(",");
            Student stu = new Student(strArr[0],strArr[1],strArr[2],strArr[3],strArr[4]);
            stuArr.add(stu);
        }
        br.close();
    }

    public void writeAllFile(String filePath, ArrayList<Student> stuArr) throws IOException{
        // 创建输出缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        for (int i = 0;i < stuArr.size();i++){
            Student stu = stuArr.get(i);
            String stuStr = stu.toString();
            /*StringBuilder strB = new StringBuilder();
            strB.append(stu.getId()).append(",").append(stu.getName()).append(",")
                    .append(stu.getAge()).append(",").append(stu.getAddress());*/
            bw.write(stuStr);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    public void findAllStudent(String filePath, ArrayList<Student> stuArr) throws IOException{
        // 将文件中的数据读取到集合中
        readAllFile(filePath,stuArr);
        if (stuArr.size() == 0){
            System.out.println("目前没有学生可供查询，请先添加学生");
            return;
        }
        System.out.println("学号\t姓名\t性别\t年龄\t居住地");
        for (int i = 0;i < stuArr.size();i++){
            Student stu = stuArr.get(i);
            System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getGender()+"\t"+stu.getAge()+"\t"+stu.getAddress());
        }
    }

    public void addStudent(String filePath, ArrayList<Student> stuArr) throws IOException{
        // 将文件中的数据读取到集合中
        readAllFile(filePath, stuArr);
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //为了让id能够被访问到，我们就把id定义在了循环的外面
        String id;
        while (true){
            // 注意，这里接收字符串不能使用 nextLine() 会被略过
            System.out.print("请输入学号：");
            id = sc.next();
            boolean flag = true;
            for (int x = 0;x < stuArr.size();x++){
                Student stu = stuArr.get(x);
                String thisId = stu.getId();
                if (thisId.equals(id)){
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

        System.out.print("请输入性别：");
        String gender = sc.next();

        System.out.print("请输入年龄：");
        String age = sc.next();

        System.out.print("请输入地址：");
        String address = sc.next();

        // 构造学生对象
        Student stu = new Student(id, name, gender, age , address);

        // 添加学生
        stuArr.add(stu);
        // 将集合的数据重新写入到文件
        writeAllFile(filePath, stuArr);

        // 给出提示
        System.out.println("添加学生成功");
    }

    public void delStudent(String filePath, ArrayList<Student> stuArr) throws IOException{
        // 将文件中的数据读取到集合中
        readAllFile(filePath,stuArr);

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想要删除的学生学号：");
        String id = sc.next();

        // 因为存的是对象，所以不能使用indexOf方法
        // 首先判断是否有学生
        if (stuArr.size() == 0){
            System.out.println("目前本系统中并没有学生信息，请输入学生信息后在进行查询操作");
            return;
        }
        int re = 0;
        for (int x = 0;x < stuArr.size();x++){
            Student stu = stuArr.get(x);
            String thisId = stu.getId();
            // 字符串使用equals比较
            if (thisId.equals(id)){
                stuArr.remove(stu);
                re++;
            }
        }
        if (re == 0){
            System.out.println("系统中并没有符合条件的学生");
            return;
        }
        // 将新集合写入文件
        writeAllFile(filePath, stuArr);
        System.out.println("删除学生成功");
    }

    public void setStudent(String filePath, ArrayList<Student> stuArr) throws IOException{
        // 将文件中的数据读取到集合中
        readAllFile(filePath, stuArr);

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想要修改的学生学号：");
        String id = sc.next();

        // 因为存的是对象，所以不能使用indexOf方法
        // 首先判断是否有学生
        if (stuArr.size() == 0){
            System.out.println("目前本系统中并没有学生信息，请输入学生信息后在进行查询操作");
            return;
        }
        int set = 0;
        for (int x = 0;x < stuArr.size();x++){
            Student stu = stuArr.get(x);
            String thisId = stu.getId();
            // 字符串使用equals比较
            if (thisId.equals(id)){
                // 获得输入值列
                System.out.print("请输入新学号：");
                String newId = sc.next();

                System.out.print("请输入新名字：");
                String newName = sc.next();

                System.out.print("请输入新性别：");
                String newGender = sc.next();

                System.out.print("请输入新年龄：");
                String newAge = sc.next();

                System.out.print("请输入新地址：");
                String newAddress = sc.next();


                // 更新数据列
                stu.setId(newId);
                stu.setName(newName);
                stu.setGender(newGender);
                stu.setAge(newAge);
                stu.setAddress(newAddress);
                set++;
            }
        }
        if (set == 0){
            System.out.println("系统中并没有符合条件的学生");
            return;
        }

        // 把集合中的数据重新写到文件
        writeAllFile(filePath, stuArr);
        System.out.println("更新数据完成");
    }

}
