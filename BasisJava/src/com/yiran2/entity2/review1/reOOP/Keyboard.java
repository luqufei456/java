package com.yiran2.entity2.review1.reOOP;

/**
 * 键盘类
 *
 * 键盘是硬件类的子类,是USB接口的实现类
 *
 * 重写方法:
 * 		开启功能参数:无	返回值:无	方法内容:连接键盘
 *		工作方法参数:无	返回值:无	方法内容:打印键盘按键
 *		关闭功能参数:无	返回值:无	方法内容:断开键盘
 * */

public class Keyboard extends Hardware implements USB {
    /**
     * open
     *  开启功能
     *  USB#open()
     * */
    @Override
    public void open(){
        System.out.println("连接键盘");
    }

    /**
     * close
     *  关闭功能
     *  USB#close()
     * */
    @Override
    public void close(){
        System.out.println("断开键盘");
    }

    /**
     * work
     *  工作方法
     *  (USB&Hardware)#work()
     * */
    @Override
    public void work(){
        System.out.println("键盘按键");
    }
}
