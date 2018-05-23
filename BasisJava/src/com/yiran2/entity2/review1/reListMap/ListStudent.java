package com.yiran2.entity2.review1.reListMap;

/**
 * 学生类
 *
 *    定义一个学生类Student，属性：姓名(String name)、
 *    班级班号(String class_number)、分数(double score)
 * */

public class ListStudent {
    // 分别定义 姓名、班号、分数
    private String name;
    private String classNumber;
    private double score;

    public ListStudent(){}

    public ListStudent(String name, String classNumber, double score){
        this.name = name;
        this.classNumber = classNumber;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
