package com.yiran3.entity1.javaThread.waitNotify.Demo3;

import com.yiran3.entity1.javaThread.waitNotify.Demo1.ThreadPerson1;

/**
 * 等待唤醒机制
 *
 *    开启生产者与消费者线程的主线程逻辑
 *
 *    生产者与消费者的线程执行目标可以通过构造方法传入共同操作的同一个资源对象
 *
 *    生产者和消费者线程安全解决：
 *    	将生产过程和消费过程都使用synchronized包裹代码块，并且使用共享对象作为锁。
 *
 *    Object类的方法：
 *    	public final void wait() throws InterruptedException：让线程等待；
 *    	public final void notify()：唤醒等待的线程 随机唤醒
 *
 *    解决等待唤醒操作：
 *    	1、在Person类中定义标志位；
 *    	2、
 *    		在生产者线程执行目标中，先判断是否有数据
 *    		有：生产者线程等待(使用锁wait)
 *    		无：正常生产
 *    		该标记位为true
 *    		唤醒消费者
 *    	3、
 *    		在消费者线程执行目标中，先判断是否有数据
 *    		有：正常消费
 *    		无：消费者线程等待(使用锁wait)
 *    		该标记位为false
 *    		唤醒生产者
 *
 *    sleep与wait方法是否都释放锁：
 *    	sleep由于线程会苏醒，所以不释放锁，相当于暂时停止，不切换线程；
 *    	wait释放锁，由其他线程唤醒等待的这个线程，被唤醒后，会继续执行wait代码后边的代码
 *
 *    生产者生成：
 *    消费者消费：
 * */

public class WaitNotifyDemo3 {
    public static void main(String[] args){
        // 创建共享资源
        ThreadPerson1 threadPerson = new ThreadPerson1();

        // 创建生产者线程执行目标
        NewPutIn2 putIn = new NewPutIn2(threadPerson);

        // 创建消费者线程执行目标
        NewGetOut2 getOut = new NewGetOut2(threadPerson);

        // 开启生产者线程
        Thread putInThread = new Thread(putIn);
        putInThread.start();

        // 开启消费者线程
        Thread getOutThread = new Thread(getOut);
        getOutThread.start();
    }
}
