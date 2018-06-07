package com.yiran3.entity2.prepareDemo.jdbcStuManagerSystem;

/**
 * jdbc学生类
 * */

public class JdbcStudent {
    private String sno;
    private String sname;
    private int age;
    private double score;

    public JdbcStudent(){}

    public JdbcStudent(String sno, String sname, int age, double score){
        this.sno = sno;
        this.sname = sname;
        this.age = age;
        this.score = score;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
