package com.yiran2.entity2.javaLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 集合(数据，添加，删除，取值遍历)
 *
 * 链表的测试类
 *
 *  LinkedList是方便添加删除的List。
 *  提供了大量首尾操作
 *
 *  public void addFirst(E e)	添加首个元素
 *  public void addLast(E e)	添加最后元素
 *  public E getFirst()			获取首个元素
 *  public E getLast()			获取最后元素
 *
 *  运行程序后会发现 为什么删掉了0  而不是 5 这是因为 push 等价于 addFirst
 *  我们用 add 相当于 addLast  来添加元素
 *  所以说：
 *          push配合pop     栈结构(容器先进后出规则)
 *          add 配合pop     相当于实现了队列结构(容器先进先出规则)
 *         offer配合poll    队列结构
 *
 *       LinkList同时支持栈结构与队列结构
 * */

public class LinkedListDemo1 {
    public static void main(String[] args){
        // 创建集合对象
        LinkedList<String> list = new LinkedList<String>();

        // 先向集合中添加一些元素
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        // 获取元素
        String Str1 = list.get(1);
        System.out.println("下标为1的元素目前是："+Str1);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String thisString = iterator.next();
            System.out.println(thisString);
        }

        System.out.println();
        // 使用增强for循环
        for (String thisStr : list){
            System.out.println(thisStr);
        }

        System.out.println();
        // 使用首尾的添加与删除动作
        // 直接输出list
        System.out.println("list:"+list);

        list.addFirst("0");
        list.addLast("5");

        System.out.println("list:"+list);

        // 这里可能会发现 为什么删掉了0  而不是 5 这是因为 push 等价于 addFirst
        // 我们用add 相当于 addLast
        // 所以说， push配合pop   栈结构(容器先进后出规则)
        //         add 配合pop   队列结构(容器先进先出规则)
        System.out.println("第一次pop:"+list.pop());
        System.out.println("list:"+list);
    }
}
