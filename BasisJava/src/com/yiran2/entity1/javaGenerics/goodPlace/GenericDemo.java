package com.yiran2.entity1.javaGenerics.goodPlace;

import com.yiran2.entity1.javaIterator.avgAgeAndException.Person;

import java.util.ArrayList;

/**
 * 泛型优点
 *
 * 提高程序的安全性
 * 将运行期问题转移到了编译期
 * 省去了类型强转的麻烦
 * */

public class GenericDemo {
    public static void main(String[] args){
        // 定义几个不同类型用于测试的变量
        // 从之前别的包里面借用一下Person，重新写有点麻烦
        Person yiran = new Person("依然",21);
        String name = "yiran";
        int QQ = 1976967579;
        char[] chs = {'a','b','c'};

        // 创建一个默认类型的集合，Object类型
        ArrayList list = new ArrayList();
        list.add(yiran);
        list.add(name);
        list.add(QQ);
        list.add(chs);

        // 使用增强for循环遍历
        for (Object o : list){
            // 存入的Object类型取出也是Object类型,使用String特有方法必须强转
            // 而且还很有可能无法转换为指定的类型，从而运行时报错,比如这里就报错了
            // 如果这里使用泛型，定义为某种类型，就不需要强转
            String s = (String)o;
            System.out.println(s.length());
        }
    }
}
