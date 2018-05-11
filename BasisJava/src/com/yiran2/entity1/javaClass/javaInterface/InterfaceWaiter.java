package com.yiran2.entity1.javaClass.javaInterface;

/**
 * 具体子类Waiter服务员类
 * 定义抽象父类的具体子类
 * */

public class InterfaceWaiter extends InterfaceEmployee {
    // 重写了父类的抽象方法，加入方法体，描述出具体逻辑
    @Override
    public void work(){
        System.out.println(this.getName()+"等待顾客叫餐！");
    }

    public InterfaceWaiter(){
        System.out.println("服务员类的无参构造方法");
    }

    //子类的构造方法可以调用父类的构造方法
    //这里,一个参数的子类构造,调用了父类一个参数的构造,为父类的成员变量赋值
    //但是最终还是子类对象自己使用这个成员变量
    public InterfaceWaiter(String name){
        super(name);
        System.out.println("服务员类的有参构造方法");
    }
}
