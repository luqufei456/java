package com.yiran2.entity1.javaClass.inheritance.homework;

/**
 * 经理类
 *
 *	定义子类经理类
 * 	经理类,多加了奖金,工作方法为打印"管理酒店"
 * */

public class TheManager extends TheEmployee {
    // 奖金
    private double bonus;

    public TheManager(){
        System.out.println("调用经理类无参构造方法");
    }

    public TheManager(String name, double salary,double bonus){
        super(name,salary);
        this.bonus = bonus;
        System.out.println("调用经理类有参构造方法");
    }

    // 重写工作方法 -- 经理工作方法
    @Override
    public void work(){
        System.out.println("经理"+this.getName()+"：管理酒店");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
