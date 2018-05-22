package com.yiran2.entity2.iO.objectStream;

import java.io.Serializable;

/**
 * Person类
 *
 *      普通类需要实现序列化接口Serializable,开启其序列化功能
 *      Serializable其实只是一个标记一样的存在，其中并没有定义方法属性等
 *      然后才可以使用序列化流或反序列化流
 *
 *    序列化ID(serialVersionUID,序列化版本号)，用于记录该对象的类型。
 *    每个被序列化操作的对象其对象ID与接收类型的ID必须相同。
 * */

public class PersonStream implements Serializable{
    /**
     * @Fields serialVersionUID : 序列化ID
     */
    private static final long serialVersionUID = -176712197696520L;

    private String name;
    private int age;

    public PersonStream(){}

    public PersonStream(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @Title: toString
     * @Description: 重写toString方法
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
