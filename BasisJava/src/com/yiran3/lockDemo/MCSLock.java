package com.yiran3.lockDemo;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class MCSLock {
    public static class MCSNode {
        // 持有后继者的引用
        MCSNode next;
        // 默认是在等待锁
        boolean locked = true;
    }

    volatile MCSNode tail;// 指向最后一个申请锁的MCSNode

    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(MCSLock.class, MCSNode.class, "tail");

    public void lock(MCSNode currentThreadMcsNode) {
        // 更新tail为最新加入的线程节点，并取出之前的节点（也就是前驱）
        MCSNode predecessor = UPDATER.getAndSet(this, currentThreadMcsNode);//step4
        // 前驱为空表示没有线程占用锁
        if (predecessor != null) {
            // 将当前节点设置为前驱节点的后继者
            predecessor.next = currentThreadMcsNode;//step5
            // 轮询自己的isLocked属性
            while (currentThreadMcsNode.locked) {

            }
        }
    }

    public void unlock(MCSNode currentThreadMcsNode) {
        // UPDATER.get(this) 获取最后加入的线程的node
        // 如果获取到的最后加入的node和当前node（currentThreadMcsNode）不相同，表示还有其他线程等待锁，直接修改后继者的isLocked属性。
        // 相同代表当前没其他有线程等待锁，进入下面的处理
        if (UPDATER.get(this) == currentThreadMcsNode) {// step1
            // 这个时候可能会有其他线程又加入了进来，检查时候有人排在自己后面，currentThreadMcsNode.next 表示依然没有染排在自己后面
            if (currentThreadMcsNode.next == null) { // step2
                //将tail设置为空，如果返回true设置成功，如果返回false，表示设置失败（其他线程加入了进来，使得当前tail持有的节点不等于currentThreadMcsNode）
                if (UPDATER.compareAndSet(this, currentThreadMcsNode, null)) { //step3
                    // 设置成功返回，没有其他线程等待锁
                    return;
                } else {
                    // 突然有其他线程加入，需要检测后继者是否有值，因为：step4执行完后，step5可能还没执行完
                    while (currentThreadMcsNode.next == null) {
                    }
                }
            }
            //修改后继者的isLocked,通知后继者结束自旋
            currentThreadMcsNode.next.locked = false;
            currentThreadMcsNode.next = null;// for GC
        }
    }
}
