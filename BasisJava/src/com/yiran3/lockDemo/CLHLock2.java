package com.yiran3.lockDemo;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class CLHLock2 {

    public static class CLHNode {
        // 默认在等待锁
        private boolean isLocked = true;
    }

    // tail 指向最后加入的线程 node
    private volatile  CLHNode tail;
    // AtomicReferenceFieldUpdater基于反射的实用工具，可以对指定类的指定 volatile 字段进行原子更新。
    // 对CLHLock2类的tail字段进行原子更新。
    private static final AtomicReferenceFieldUpdater<CLHLock2, CLHNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(CLHLock2.class, CLHNode.class, "tail");

    /**
     * 将node通过参数传入，其实和threadLocal类似，每个线程依然持有了自己的node变量
     * @param currentThread
     */
    public void lock(CLHNode currentThread) {
        CLHNode preNode = UPDATER.getAndSet( this, currentThread);
        // 如果preNode为空，表示当前没有线程获取锁，直接执行。
        if(preNode != null) {
            // 轮询前驱状态
            while(preNode.isLocked ) {
            }
        }
    }

    // 我看这里，这个方法有点问题啊，如果队列里就它一个的话，那 unlock 一次，没线程在等待，那就不改isLocked了？？
    // 那后面再进一个线程，尝试获取锁，但是这个线程实际上已经扔掉锁了，GG，感觉这里加个轮询关闭锁比较好
    public void unlock(CLHNode currentThread) {
        // compareAndSet,如果当前tail里面和currentThread相等，设置成功返回true，
        // 表示之后没有线程等待锁，因为tail就是指向当前线程的node。
        // 如果返回false，表示还有其他线程等待锁，则更新isLocked属性为false
        if (!UPDATER .compareAndSet(this, currentThread, null)) {
            currentThread. isLocked = false ;// 改变状态，让后续线程结束自旋
        }
    }
}
