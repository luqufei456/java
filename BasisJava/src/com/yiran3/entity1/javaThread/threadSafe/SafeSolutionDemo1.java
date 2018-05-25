package com.yiran3.entity1.javaThread.threadSafe;

/**
 * 多线程安全问题的解决方案
 *
 *   多线程安全问题的解决方案：
 *    	Java中使用synchronized关键字来解决，将一个完整动作使用synchronized包裹。
 *
 *    同步代码块格式：
 *    	synchronized (锁对象) {
 *    		可能会产生线程安全问题的代码
 *    	}
 *
 *    同步代码块中的锁对象可以是任意的对象；但多个线程操作相同数据时，
 * 要使用同一个锁对象才能够保证线程安全，避免安全问题。
 *
 *    同步解决方案解释：
 *    	即线程A中操作数据的代码与线程B中操作数据的代码均使用synchronized包裹，并使用相同的锁对象。
 *    	线程A先进入了同步块，这时线程B会等待线程A中synchronized包裹的代码执行完毕后再执行，
 * 	此时线程A已经操作完了代码，反之线程A也会等待线程B。
 *
 * 	  不同同步代码块使用相同锁对象，依然可以起到同步效果
 * */

public class SafeSolutionDemo1 implements Runnable{
    private int num = 100;

    // 在成员位置定义锁对象
    private Object lock = new Object();

    // 完成卖票逻辑
    @Override
    public void run(){
        // 车站不停地卖票
        while (true){
            // 将一个完整的动作使用synchronized包裹
            synchronized (this){
                // 通过sleep的测试可以看出，只要有一个线程进入synchronized块，其余线程就被阻塞了
                try {
                    Thread.sleep(20);
                } catch (Exception e){
                    e.printStackTrace();
                }
                if (num > 0){
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName+"正在销售第"+num+"张票");
                    num--;
                }
                else{
                    // 没票了就不卖了
                    return;
                }
            }
        }
    }
}
