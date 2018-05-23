package com.yiran2.entity2.review1.reOOP;

/**
 * 笔记本类
 *
 * 笔记本类中方法:
 *		开机功能参数:无	返回值:无	功能内容:打印开机,创建电脑屏幕类对象,调用显示画面方法
 *		关机功能参数:无	返回值:无	功能内容:打印关机
 *		使用USB设备的功能
 *			参数:USB接口参数(形式参数)
 *			返回值:无
 *			功能内容:调用USB设备的三个功能:开启功能,工作方法,关闭功能
 * */

public class Computer {
    /**
     * begin
     *  开机方法
     * */
    public void begin(){
        System.out.println("开机");
        // 创建电脑屏幕对象
        Screen sc = new Screen();
        // 调用显示屏幕方法
        sc.work();
    }

    /**
     * over
     *  关机方法
     * */
    public void over(){
        System.out.println("关机");
    }

    /**
     * useUSB
     *  使用USB功能
     * */
    public void useUSB(USB usb){
        usb.open();
        usb.work();
        usb.close();
    }
}
