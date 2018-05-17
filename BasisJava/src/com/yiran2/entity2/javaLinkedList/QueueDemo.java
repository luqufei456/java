package com.yiran2.entity2.javaLinkedList;

import java.util.LinkedList;

/**
 * queue队列结构
 *
 * 	queue队列结构:先进先出
 *
 * 	LinkedList是支持队列结构的
 *
 * 	对应的方法
 * 		offer加入队列
 * 		poll离开队列
 * 		peek查询出即将要离开队列的是哪个元素,检查有没有要离开队列的元素
 * */

public class QueueDemo {
    public static void main(String[] args){
        // 创建队列结构的集合
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer("依然");
        queue.offer("miku");
        queue.offer("蠢觉");
        queue.offer("poi");

        // 查看队列结构是如何显示
        System.out.println(queue);

        //获取一个元素,此时,由于是队列结构,所以获取的是最早入队的元素
        String pollName = queue.poll();
        System.out.println(pollName);

        // 出队后，集合中减少元素 相当于每次都删第一个
        System.out.println(queue);

        // peek查询出即将要离开队列的是哪个元素,检查有没有要离开队列的元素
        String peekName = queue.peek();
        System.out.println("peek："+peekName);

        //peek查看元素不会减少元素
        System.out.println(queue);

        // 出队一个，看看是否是peek查询出来的
        System.out.println("peek后第一次poll："+queue.poll());

    }
}
