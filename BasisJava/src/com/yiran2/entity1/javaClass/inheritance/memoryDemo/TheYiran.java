package com.yiran2.entity1.javaClass.inheritance.memoryDemo;

/**
 * 子类
 *
 * 在父类Person的基础上,多了地址属性：
 * 	address
 * */

public class TheYiran extends ThePerson{
    private String address;

    public TheYiran(){
        System.out.println("子类的哈希code为："+this.hashCode());
        System.out.println("看地址是否相同"+super.equals(this));
    }

    public TheYiran(String name, int age,String address) {
        super(name, age);
        this.address = address;
        System.out.println("子类的哈希code为："+this.hashCode());
        System.out.println("看地址是否相同"+super.equals(this));
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
