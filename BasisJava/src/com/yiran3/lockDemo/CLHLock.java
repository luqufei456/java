package com.yiran3.lockDemo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CLH自旋锁，前驱自旋
 */
public class CLHLock {
    // 指向最后加入的线程
    AtomicReference<Node> tail = new AtomicReference<>();
    // 当前线程持有的节点，使用ThreadLocal实现了变量的线程隔离
    ThreadLocal<Node> node;
    // 前驱节点，使用ThreadLocal实现了变量的隔离
    ThreadLocal<Node> preNode = new ThreadLocal<>();

    public CLHLock() {
        // 初始化node
        node = new ThreadLocal<Node>() {
          // 线程默认变量的值，如果不继承重写，默认为 null
          @Override
          protected Node initialValue() {
              return new Node();
          }
        };
        // 初始化 tail，指向一个 node，类似一个 head 节点，并且该节点的 locked 属性为 false
        tail.set(new Node());
    }

    public void lock() {
        // 因为上面提到的构造函数中initialValue()方法，所以每个线程会有一个默认的值
        // 并且node的locked属性为false.
        Node myNode = node.get();
        // 修改为true，表示需要获取锁
        myNode.locked = true;
        // 获取这之前最后加入的线程，并把当前加入的线程设置为tail，
        // AtomicReference的getAndSet操作是原子性的
        Node preNode = tail.getAndSet(myNode);
        this.preNode.set(preNode);
        while (preNode.locked) {
            // 轮询前驱节点的locked属性，尝试获取锁
        }
    }

    public void unlock() {
        // 解锁很简单，将节点locked属性设置为false，
        // 这样轮询该节点的另一个线程可以获取到释放的锁
        node.get().locked = false;
        // 当前节点设置为前驱节点，也就是上面初始化提到的head节点
        // 比如 head - A - B   A 释放锁后 head - B
        node.set(preNode.get());
    }

    private class Node {
        // 默认不需要锁
        private boolean locked = false;
    }
}
