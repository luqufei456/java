package com.yiran3.entity2.prepareDemo.listStuManagerSystem;

public class ListStudent1 implements Comparable<ListStudent1>{
    private String sno;
    private String sname;
    private int age;
    private double score;

    public ListStudent1(){}

    public ListStudent1(String sno, String sname, int age, double score){
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

    @Override
    public String toString(){
        return this.sno+", "+this.sname+", "+this.age+", "+this.score;
    }

    //  Collections.sort 借此来排序
    @Override
    public int compareTo(ListStudent1 stu){
        String s1 = this.getSno().split("s")[1];
        int sno1 = Integer.parseInt(s1);

        String s2 = stu.getSno().split("s")[1];
        int sno2 = Integer.parseInt(s2);
        return sno1 - sno2;

    }
}
