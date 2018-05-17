package com.yiran2.entity1.javaGenerics.classType;

/**
 * 自定义类中使用泛型
 *
 * 在该类中定义一个成员变量,使用泛型
 *
 * 不指定其数据类型,是一个不确定的数据类型.
 * 创建不同的对象时,指定不同的数据类型
 *
 * class  类名<E,T,……>{    // <>中的泛型可以写无数个
 *     //E,T……能够做为类型在该类内部被使用
 * }
 *
 *
 * 在调用泛型方法,并且传入实参的时候才能确定方法上形参的类型
 * 不同于之前使用泛型类的 <T> 的get和set方法
 *
 * 修饰符 <T,Q,E……> 返回值类型 方法名(T t,Q q,……){   // 方法上的泛型定义在返回值的前面
 *
 * }
 * */

public class MyClassType1<T> {
    /**
     * @Fields myField : 我的字段
     */
    private T myField;

    /**
     * @return the myField
     */
    public T getMyField(){
        return this.myField;
    }

    /**
     * @param myField the myField to set
     */
    public void setMyField(T myField){
        this.myField = myField;
    }

    // 泛型方法  在调用泛型方法,并且传入实参的时候才能确定方法上形参的类型
    public <E> void methods(E e){
        System.out.println("e:"+e);
    }

}
