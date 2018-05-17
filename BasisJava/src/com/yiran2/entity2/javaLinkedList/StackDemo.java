package com.yiran2.entity2.javaLinkedList;

import java.util.LinkedList;

/**
 * stack栈结构
 *
 *  stack栈结构:先进后出
 *
 *  LinkedList是支持栈结构的.

 *  	对应的方法
 *  		push压栈
 *  		pop弹栈
 *  		peek查询出即将要弹出的是哪个元素,检查有没有要弹出的元素
 *
 *  java提供了一个专门用于栈结构的类,Stack
 *
 *  peek()   检索但不删除此列表的头（第一个元素）,也就是即将被弹出的元素。
 * */

public class StackDemo {
    public static void main(String[] args){
        // 创建栈结构的集合 注意这里不能使用add 这样就相当于往后面加，而push是往前加的 等价于addFirst
        LinkedList<String> stack = new LinkedList<String>();

        stack.push("依然");
        stack.push("鸽l");
        stack.push("miku");
        stack.push("蠢觉");

        System.out.println(stack);

        // 获取一个元素，因为使用的是push+pop，所以为栈结构，先进后出，后进先出，获取的为最后压栈的元素
        String popName = stack.pop();
        System.out.println(popName);

        // 弹栈动作,集合中减少元素
        System.out.println(stack);

        // peek()   检索但不删除此列表的头（第一个元素），也就是即将被弹出的元素。
        String peekName = stack.peek();
        System.out.println("peek："+peekName);

        // 查看peek是否不会减少栈的元素
        System.out.println(stack);

        // 查看peek的元素是否为下一个pop 弹出的元素 ，结果是的。
        System.out.println("peek后的第一次pop："+stack.pop());
    }
}
