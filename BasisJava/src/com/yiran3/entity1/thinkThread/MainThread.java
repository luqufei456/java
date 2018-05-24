package com.yiran3.entity1.thinkThread;

/**
 *     在下面的实例中，这个任务的run()不是由单独的线程驱动的，它是在main()中
 * 直接调用的(实际上，这里仍然使用了线程，即总是分配给main()的那个线程)
 * */

public class MainThread {
    public static void main(String[] args){
        LiftOff admin = new LiftOff();
        admin.run();
    }
}
