package com.yiran2.entity2.review1.reOOP;

/**
 * 鼠标类
 *
 * 鼠标是硬件类的子类,是USB接口的实现类
 *
 * 重写方法:
 * 		开启功能参数:无	返回值:无	方法内容:连接鼠标
 *		工作方法参数:无	返回值:无	方法内容:打印鼠标点击
 *		关闭功能参数:无	返回值:无	方法内容:断开鼠标
 *
 *      Type1和Type2中都有一个f()方法，那么IFTest中的f()方法到底实现的是Type1中的f()呢，
 * 还是Type2中的f()呢？其实，这种疑问是多余的，因为IFTest中的f()既是Type1中的f()也是Type2中的f()。
 * 因为既然IFTest这个类没有发生编译错误，那就说明它既实现Type1也实现了Type2，
 * 也就是说Type1中的f()与Type2中的f()在IFTest中是相安无事的。
 * */

public class Mouse extends Hardware implements USB{
    /**
     * open
     *  开启功能
     *  USB#open()
     * */
    @Override
    public void open(){
        System.out.println("连接鼠标");
    }

    /**
     * close
     *  关闭功能
     *  USB#close()
     * */
    @Override
    public void close(){
        System.out.println("断开鼠标");
    }

    /**
     * work
     *  工作方法
     *  (USB&Hardware)#work()
     * */
    @Override
    public void work(){
        System.out.println("鼠标点击");
    }
}
