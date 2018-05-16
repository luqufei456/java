package com.yiran2.entity1.javaIterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 迭代器的使用
 *
 *  在java当中不止ArrayList一个集合,java提供了众多的集合.
 *
 *  不同的容器完成不同方式的数据存储.
 *  不同集合的特点不同,ArrayList有序且可重复且带索引的集合.但是有的集合不带索引.所以如果使用其他集合,可能无法通过get+索引的方式获取元素
 *
 *  所有集合的通用获取元素方法并不是通过索引获取,而是通过迭代器获取.
 *  迭代器:iterator
 *
 *  hasNext()方法：用来判断集合中是否有下一个元素可以迭代。如果返回true,说明可以迭代。
 *  next()方法：用来返回迭代的下一个元素，并把指针向后移动一位。
 *
 *
 * 迭代器原理
 *
 *  集合用来持有数据，所有常用集合都具备了可迭代功能iterator方法，该方法用于迭代集合，该方法才是最为通用的集合迭代方法。
 *
 *  迭代器:集合迭代(集合遍历)的工具
 *
 *  集合的获取迭代器方法
 *  public Iterator<E> iterator()  获取某个集合的迭代器实例对象
 *
 *  Iterator:迭代器接口
 *  		booleanhasNext()  判断集合中是否有下一个元素不移动元素指针
 *  		E next()  获取集合中下一个元素移动指针,指向下一个元素
 * */

public class IteratorDemo1 {
    public static void main(String[] args){
        // 创建集合对象
        ArrayList<Integer> intList = new ArrayList<Integer>();

        // 像集合中添加元素
        intList.add(10);
        intList.add(20);
        intList.add(20);
        intList.add(30);

        /*ArrayList<Integer> intList2 = new ArrayList<Integer>(intList);

        System.out.println(intList2);

        System.out.println(intList);

        for (int i = 0;i < intList.size();i++){
            if (intList.get(i) == 20){
                intList.remove(intList.get(i));
            }
        }*/

        /*for (int i = 0;i < intList2.size();i++){
            if (intList2.get(i) == 20){
                intList.remove(intList2.get(i));
            }
            System.out.println(intList);
        }
*/
        System.out.println(intList);

        // 获取该集合的迭代器
        Iterator<Integer> iterator = intList.iterator();

        // 使用迭代器的方法，迭代集合(遍历集合)
        while (iterator.hasNext()){ // 如果里面没有元素了就会返回flase 循环就停止
            Integer thisInteger = iterator.next();
            System.out.println(thisInteger);
        }

    }
}
