package com.yiran2.entity1.javaGenerics.interType;

/**
 * 实现泛型接口的泛型类
 *
 * 	定义类时,仍然不指定接口中的数据类型
 * 	则此时相当于将这种不确定的数据类型用到了类中
 * 	包含不确定的数据类型的类,是泛型类,如同一个泛型类的定义和使用
 * */

public class MyClassInter2<T> implements MyInterType1<T>{
    // 由于没有指定接口中具体的数据类型,所以方法中仍然使用这种不确定的数据类型
    @Override
    public void method(T t){
        System.out.println("实现泛型接口的泛型类，我也不知道接收的参数是什么类型："+t);
    }
}
