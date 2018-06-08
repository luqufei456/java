package com.yiran3.entity2.dbUtilsDemo.queryDemo;

/**
 *     JavaBean就是一个类，在开发中常用语封装数据。与查询所对应的表息息相关，
 * 相当于将表中的每一行封装为一个对象。具有如下特性
 *    1. 需要实现接口：java.io.Serializable ，通常实现接口这步骤省略了，不会影响程序。
 *    2. 提供私有字段：private 类型 字段名;
 *    3. 提供getter/setter方法：
 *    4. 提供无参构造
 *    5. 字段类型、字段名，字段数量，必须与表结构一致。
 * */

public class Product implements java.io.Serializable{
    private int pid;
    private String pname;
    private double price;
    private int cid;

    public Product(){}

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString(){
        return pid+", "+pname+", "+price+", "+cid;
    }
}
