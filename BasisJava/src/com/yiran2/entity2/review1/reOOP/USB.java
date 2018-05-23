package com.yiran2.entity2.review1.reOOP;

/**
 * USB接口
 *
 *  USB接口中方法:
 *		开启功能参数:无  返回值:无
 *		工作方法参数:无  返回值:无
 *		关闭功能参数:无  返回值:无
 * */

public interface USB {
    /**
     * open
     *  开启功能
     */
    public abstract void open();

    /**
     * work
     *  工作功能
     */
    public abstract void work();

    /**
     * close
     *  关闭功能
     */
    public abstract void close();
}
