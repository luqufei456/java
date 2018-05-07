package com.yiran.entity.polymorphism;

public class PolymorphismTest1 {
    public static void main(String[] args){
        System.out.println("测试子类 蠢觉");
        SuperClass chunjue = new SubClass2("chunjue",25,false); // 向上转型

        // 普通成员方法，使用子类的，所以获取到的子类的成员变量 这里使用的是子类的成员方法
        chunjue.getLevel();
        System.out.println();

        // 使用对象.变量 所以获取到的是超类的成员变量
        System.out.println(chunjue.level);
        System.out.println();

        // 尝试使用子类扩展的接口，由于超类没有该方法，所以无法使用
        // chunjue.studyMath();

        // 使用静态方法 可以看到，使用的还是超类的静态方法
        chunjue.staFunction();
        System.out.println();

        System.out.println("测试子类 依然");
        SuperClass yiran = new SubClass1("yiran",21,false);

        yiran.getLevel();
        System.out.println();

        System.out.println(yiran.level);
        System.out.println();

        // yiran.playDNF();

        yiran.staFunction();
        System.out.println();

        // 向下转型
        System.out.println("向下转型后，测试");
        SubClass1 yiran1 = (SubClass1)yiran; // 向下转型

        // 得到的是子类的level属性，并不像向上转型的 父类的level
        System.out.println(yiran1.level);
        System.out.println();

        // 可以调用子类扩展的接口
        yiran1.playDNF();
        System.out.println();

        // 使用的是子类覆盖的父类的静态方法 而不是父类的静态方法
        yiran1.staFunction();

    }

}
