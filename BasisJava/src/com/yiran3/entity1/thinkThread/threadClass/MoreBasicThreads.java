package com.yiran3.entity1.thinkThread.threadClass;

import com.yiran3.entity1.thinkThread.LiftOff;

/**
 * 所有任务彼此之间是如何相互呼应的
 *
 * 在本例中，单一线程(main())在创建所有的LiftOff线程。但是，如果多个线程在创建LiftOff线程
 * ，那么就有可能会有多个LiftOff拥有相同的id，之后会了解这是为什么。
 *
 * 输出说明不同任务的执行在线程被换进换出时混在了一起。这种交换是由线程调度器自动控制的。如果
 * 在你的机器上有多个处理器，线程调度器将会在这些处理器之间默默地分发线程。
 *
 * 这个程序一次运行的结果可能与另一次运行的结果不同，因为线程调度机制是非确定性的。
 *
 * 当main()创建Thread对象时，它并没有捕获任何对这些对象的引用。在使用普通对象时，这对于垃圾回收
 * 来说是一场公平的游戏，但是在使用Thread时，情况就不同了。每个Thread都"注册"了它自己，因此确实
 * 有一个对它的引用，而且在它的任务退出其run()并死亡之前，垃圾回收器无法清除它。你可以从输出中
 * 看到，这些任务确实运行到了结束，因此，一个线程会创建一个单独的执行线程，在对start()的调用完成
 * 之后，它依旧会继续存在。
 * */

public class MoreBasicThreads {
    public static void main(String[] args){
        // 使用for循环创建5个LiftOff线程并启动
        for (int i = 0;i < 5;i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("等待LiftOff");
    }
}
