package com.yiran.entity2.arrayList;

import java.util.ArrayList;

/**
 *  为什么会出现集合类：
 * 		我们学习的是面向对象编程语言，而面向对象编程语言对事物的描述都是通过对象来体现的。
 * 		为了方便对多个对象进行操作，我们就必须对这多个对象进行存储，而要想对多个对象进行存储，
 * 		就不能是一个基本的变量，而应该是一个容器类型的变量。
 * 		到目前为止，我们学习过了哪些容器类型的数据呢？StringBuilder,数组。
 * 		StringBuilder的结果只能是一个字符串类型，不一定满足我们的需求。
 * 		所以，我们目前只能选择数组了，也就是我们前面学习过的对象数组。
 * 		但是，数组的长度是固定的，适应不了变化的需求，那么，我们该如何选择呢?
 * 		这个时候，java就提供了集合类供我们使用。
 *
 * 集合类的特点：
 * 		长度可变。
 *
 * ArrayList<E>:
 * 		大小可变数组的实现
 *
 * 		<E>:是一种特殊的数据类型，泛型。
 * 		怎么用呢?
 * 			在出现E的地方我们使用实际的引用数据类型替换即可
 * 			举例：ArrayList<String>,ArrayList<Student>
 *
 * 构造方法：
 * 		ArrayList()
 *
 * 添加元素：
 * 		public boolean add(E e):添加元素
 * 		public void add(int index,E element):在指定的索引处添加一个元素
 * */

public class ArrayListAdd {
    public static void main(String[] args){
        // 创建集合对象 长度可变，所以不需要定义
        ArrayList<String> strArr = new ArrayList<String>();

        // add(E e):添加元素
        strArr.add("hello ");
        strArr.add("my name is ");
        strArr.add("yiran");

        // add(int index,E element):在指定的索引处添加一个元素
        strArr.add(1,"chunjue"); // 是一个列表的形式，并不是字符串

        // 集合可以直接输出
        System.out.println(strArr);
    }

}
