package com.yiran2.entity2.review1.reOOP;

/**
 * 电脑屏幕子类
 *
 * 电脑屏幕是硬件类的子类
 *
 * 重写方法:
 * 		工作方法参数:无	返回值:无	方法内容:打印显示屏显示画面
 * */

public class Screen extends Hardware{
    /**
     * work
     *  工作方法
     *  Hardware#work()
     * */
    @Override
    public void work(){
        System.out.println("显示屏显示画面");
    }
}
