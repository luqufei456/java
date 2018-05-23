package com.yiran2.entity2.review1.reListMap;

import com.yiran.entity2.objectArray.Student;

import java.util.ArrayList;

/**
 * 班级类
 *
 *   班级类：班级班号、学生列表
 * */

public class ListClassRoom {
    private String classNumber;

    // 学生列表
    private ArrayList<ListStudent> students;

    public ListClassRoom(){}

    public ListClassRoom(String classNumber, ArrayList<ListStudent> students){
        this.classNumber = classNumber;
        this.students = students;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public ArrayList<ListStudent> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<ListStudent> students) {
        this.students = students;
    }
}
