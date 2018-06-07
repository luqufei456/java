package com.yiran3.entity2.prepareDemo.listStuManagerSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentsMangerList {
    List<ListStudent1> list;

    public StudentsMangerList(){
        list = new ArrayList<>();
    }

    // 1.添加学生
    public void addStudent(ListStudent1 stu){
        list.add(stu);
    }

    // 2.显示所有学员信息
    public void showStudents(){
        for (ListStudent1 thisStu: list){
            System.out.println(thisStu.toString());
        }
    }

    // 3.根据学号显示学员信息
    public void snoShowStu(String sno){
        for (ListStudent1 thisStu: list){
            if (thisStu.getSno().equals(sno)){
                System.out.println(thisStu.toString());
                return;
            }
        }
    }

    // 4.给学生评分
    public void setScore(String sno, double score){
        for (ListStudent1 thisStu: list){
            if (thisStu.getSno().equals(sno)){
                thisStu.setScore(score);
                System.out.println("修改成功");
            }
        }
    }

    // 5、根据学号删除学生
    public void delStu(String sno){
        for (ListStudent1 thisStu: list){
            if (thisStu.getSno().equals(sno)){
                list.remove(thisStu);
                System.out.println("删除成功");
            }
        }
    }

    // 6、根据学号升序排序，分页显示学员信息，每页三条
    public void showPageStu(int pageSize, int pageNum){
        // 按学号升序排序
        Collections.sort(list);
        // 分页
        for (int i = 0;i < list.size();i++){
            if ((i >= (pageNum-1) * pageSize) && (i < pageNum*pageSize)){
                System.out.println(list.get(i).toString());
            }
        }
    }
}
