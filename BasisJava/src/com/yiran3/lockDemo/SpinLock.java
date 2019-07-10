package com.yiran3.lockDemo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁：
 * 多个线程，当一个线程尝试获取锁的时候，如果锁被占用，就在当前线程循环检查锁是否被释放，这个时候线程并没有进入休眠或者挂起。
 */
public class SpinLock {
    // AtomicReference，CAS，compareAndSet保证了操作的原子性
    private AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();

        while (!owner.compareAndSet(null, currentThread)){
            // CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。
            // 当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。
            // 这里意思是，如果锁没有被占用的话，就占用，否则一直循环检查锁是否被释放
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();

        // 只有锁的拥有者才能释放锁，只有上锁的线程获取到的 currentThread，才和内存中的 currentThread 相等。
        owner.compareAndSet(currentThread, null);
    }
}
