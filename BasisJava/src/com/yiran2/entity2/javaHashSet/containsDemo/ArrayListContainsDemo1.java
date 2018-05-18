package com.yiran2.entity2.javaHashSet.containsDemo;

import java.util.ArrayList;

/**
 * ArrayList中contains方法如何判断是否有重复元素
 *
 *      自定义类型Person类是Object类的子类，所以Person具备equals方法contains方法会调用参数的equals方法，
 * 依次与集合当中已经存在的Person对象比较。
 *      当Person类没有重写equals方法时，直接使用Object类基础过来的equals方法，而该方法比较的是对象地址值。
 *      当Person类重写equals方法后，就可以讲比较规则由比较地址值改为比较属性值。
 * */

public class ArrayListContainsDemo1 {
    public static void main(String[] args){
        // 创建ArrayList对象
        ArrayList<String> arrayList = new ArrayList<String >();

        // 在list中加入数据
        arrayList.add("依然");
        arrayList.add("春雨");
        arrayList.add("逸晨");
        arrayList.add("蠢觉");
        arrayList.add("miku");

        // 判断集合中是否存在依然
        System.out.println("判断是否存在依然："+arrayList.contains("依然"));
        System.out.println();

        //ArrayList当中存储自定义数据类型Person
        ArrayList<Person> personArrayList = new ArrayList<Person>();

        Person yiran = new Person("依然",21);
        Person chunjue = new Person("蠢觉",25);
        Person miku = new Person("miku",23);

        personArrayList.add(yiran);
        personArrayList.add(chunjue);
        personArrayList.add(miku);

        // 测试contains比较的是内容还是地址
        // false
        System.out.println("new一个一样的依然："+personArrayList.contains(new Person("依然",21)));
        // true
        System.out.println("直接查看是否存在依然："+personArrayList.contains(yiran));

        System.out.println();
        // 使用重写的equals方法
        // 先比较一个属性一样的
        System.out.println("使用重写的equals比较是否存在依然1："+personArrayList.contains(new Person("依然",21)));
        // 再比较一个属性不一样的
        System.out.println("使用重写的equals比较是否存在依然2："+personArrayList.contains(new Person("依然",22)));
    }
}
