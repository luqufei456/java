package com.yiran2.entity2.javaHashSet.containsDemo;

import java.util.HashSet;

/**
 * 重写equals与hashCode方法后，查看相同属性不同对象的对象是否还能添加。
 *
 *      原来的时候，是使用Object的方法， equals比较地址， hashCode比较hash值
 * 所以，就算属性相同，只要不是同一个地址，仍然能够添加，不太符合平时项目的需求
 *
 * 这里重写equals与hashCode方法，只要属性相同，则判断为hashSet中含有该对象
 * */

public class HashSetAddDemo1 {
    public static void main(String[] args){
        // 创建hashset集合，该集合不可重复，使用add方法时会先使用hashcode判断，再使用equals判断
        HashSet<Person> hashSet = new HashSet<Person>();

        // 创建几个人类对象
        Person yiran = new Person("依然",21);
        Person chunjue = new Person("蠢觉",25);
        Person miku = new Person("miku",23);

        // 添加对象
        hashSet.add(yiran);
        hashSet.add(chunjue);
        hashSet.add(miku);

        // 试试现在创建一个新对象，但是属性与依然相同，是否能够添加到hashSet中
        Boolean isTrue = hashSet.add(new Person("依然",21));
        System.out.println("是否能够添加："+isTrue);
    }
}
