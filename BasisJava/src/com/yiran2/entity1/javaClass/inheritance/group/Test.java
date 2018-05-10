package com.yiran2.entity1.javaClass.inheritance.group;

/**
 * 组合关系的测试类
 *
 * 当一个自定义类型A的成员变量的数据类型是自定义类型B时，A类与B类叫做组合关系。
 * */

public class Test {
    public static void main(String[] args){
        String name = "依然";
        int age = 21;
        // 构造宠物对象
        Pet chunjue = new Pet("蠢觉","蠢白","人类");
        // 构造主人对象
        Person yiran = new Person("yiran",21,chunjue);

        // 调用主人类显示个人信息的方法
        yiran.showInfo();
    }
}
