package com.yiran2.entity1.javaGenerics.interType;

/**
 * 自定义泛型接口
 * */

public interface MyInterType1 <T> {
    // 接口的方法中使用接口泛型
    public abstract void method(T t);
}
