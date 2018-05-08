package com.yiran.entity2.objectArray;

/**
 * 对象数组:存储的元素为引用类型
 * Student[] stus=new Student[3];
 * Student代表一个自定义类
 * stus数组中stus[0],stus[1],stus[2]的元素数据类型为Student,都可以指向一个Student对象
 * 对象数组，只有索引处有指向对象时，才可以用set get等方法，否则会空指针异常，因为只是相当于定义了
 * Student stu; 并没有 new Student()对象 没有指向一个对象
 * */

public class ObjectArray {
}
