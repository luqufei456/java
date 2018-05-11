package com.yiran2.entity1.javaClass.javaAbstract;

/**
 * 具体子类Waiter服务员类
 * 如果继承了抽象类，没有重写抽象方法，会报错
 * */

public class AbstractWaiter extends AbstractEmployee{
    public AbstractWaiter(){
        System.out.println("我是服务员类的无参构造方法");
    }

    //子类的构造方法可以调用父类的构造方法
    //这里,一个参数的子类构造,调用了父类一个参数的构造,为父类的成员变量赋值
    //但是最终还是子类对象自己使用这个成员变量
    public AbstractWaiter(String name){
        super(name);
        System.out.println("我是服务员类的有参构造方法");
    }



    /*
     * 重写了父类的抽象方法,加入了方法体,描述出具体逻辑
     */
    @Override
    public void work(){
        System.out.println(this.getName()+"等待顾客叫餐");
    }
}
