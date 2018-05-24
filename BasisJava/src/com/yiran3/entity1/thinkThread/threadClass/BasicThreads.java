package com.yiran3.entity1.thinkThread.threadClass;

import com.yiran3.entity1.thinkThread.LiftOff;

/**
 * 将Runnable对象转变为工作任务的传统方式是把它提交给一个Thread构造器
 * 下面的示例展示了如何使用Thread来驱动LiftOff对象
 *
 *   Thread构造器只需要一个LiftOff对象。调用Thread对象的start()方法为该
 * 线程执行必须的初始化操作，然后调用Runnable的run()方法，以便在这个新线程
 * 中启动该任务。尽管start()看起来是产生了一个对长期运行方法的调用，但是从
 * 输出中可以看到，start()迅速返回了，因为Waiting for LiftOff消息在倒计时
 * 完成之前就出现了。
 *
 *   实际上，你产生的是对LiftOff.run()方法的调用，并且这个方法还没有完成，但是
 * 因为LiftOff.run()是由不同的线程执行的，因此你仍旧可以执行main()线程中的其他
 * 操作(这种能力并不局限于main()线程，任何线程都可以启动另一个线程)。因此，程序
 * 会同时运行两个方法，main()和LiftOff.run()是程序中与其他线程"同时"执行的代码。
 * */

public class BasicThreads {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
