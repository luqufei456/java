package com.yiran2.entity1.javaIterator.avgAgeAndException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList的测试类
 *
 * 	B：定义一个测试类,在测试类中定义一个集合,集合中存储三个Person对象,这三个人的属性分别为
 *  		Jack,18岁
 *  		Rose,16岁
 *  		Trump,62岁
 *	C:最终遍历该集合,分别打印出这三个人的姓名和年龄
 *		并且统计出三个人的总年龄打印在控制台上
 *	    再计算平均年龄
 *
 *
 * 迭代过程中修改产生的并发异常
 *
 *  使用集合存储多个Person对象,当遇到16岁的人时,就添加一个90岁的人
 *
 *  该例中可能会产生并发修改异常:迭代器所认为的集合状态与集合真正的状态不统一了!就会出现该异常.
 * */

public class ArrayListDemo {
    public static void main(String[] args){
        // 创建Person类的集合对象
        ArrayList<Person> perList = new ArrayList<Person>();

        // 像集合中添加元素
        Person yiran = new Person("依然",21);
        Person chunjue = new Person("蠢觉",25);
        Person miku = new Person("miku",23);

        perList.add(yiran);
        perList.add(chunjue);
        perList.add(miku);

        // 调用集合的iterator方法，返回迭代器对象
        Iterator<Person> perIterator = perList.iterator();

        // 定义变量计算年龄总值
        int sumAge = 0;

        // 使用hasNext和next方法 循环获取元素并输出几人姓名年龄
        while (perIterator.hasNext()){
            Person p = perIterator.next();
            p.show();
            sumAge += p.getAge();
        }
        System.out.println("总年龄为："+sumAge);

        // 计算平均年龄
        int avgAge = sumAge/(perList.size());
        System.out.println("平均年龄为："+avgAge);
    }
}