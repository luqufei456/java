package com.yiran2.entity1.javaClass.inheritance.homework;

import com.yiran.entity2.stuManage.Manage;

/**
 * 测试类
 *
 * 	员工类
 * 		员工姓名,员工薪水,员工工作方法
 *
 * 	经理类,多加了奖金,工作方法为打印"管理酒店"
 * 	服务员类,工作方法为打印"上菜与结账"
 * 	厨师类,工作方法为打印"做饭"
 *
 * 	共有1个经理,2个服务员,1个厨师,(所有人的属性任意定义)
 * 	让所有的员工工作
 * 	并求所有人的总收入是多少?
 * */

public class TheTest {
    public static void main(String[] args){
        // 创建4名员工
        TheManager yichen = new TheManager("杨逸晨",6000,2000);
        TheWaiter boyi = new TheWaiter("彭博弈",3000);
        TheWaiter paojie = new TheWaiter("韩志文",2500);
        TheCook mingrui = new TheCook("彭明睿",5000);

        // 调用方法使4名员工都开始工作
        employeeWork(yichen, boyi, paojie, mingrui);

        // 调用方法获得4名员工的总收入
        double sumMoney = getSumMoney(yichen, boyi, paojie, mingrui);
        System.out.println("所有人的总收入为："+sumMoney);
    }

    public static void employeeWork(TheManager m, TheWaiter w1, TheWaiter w2, TheCook c){
        m.work();
        w1.work();
        w2.work();
        c.work();
    }

    public static double getSumMoney(TheManager m, TheWaiter w1, TheWaiter w2, TheCook c){
        return m.getBonus()+m.getSalary()+w1.getSalary()+w2.getSalary()+c.getSalary();
    }
}
