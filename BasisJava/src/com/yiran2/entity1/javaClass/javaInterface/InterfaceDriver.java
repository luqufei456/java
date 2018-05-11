package com.yiran2.entity1.javaClass.javaInterface;

/**
 * 司机类
 *
 * 定义司机类
 * 		是员工的子类,继承员工
 * 		会开车,实现开车接口
 * */

public class InterfaceDriver extends InterfaceEmployee implements DrivingCar{
    public InterfaceDriver(){
        System.out.println("司机类的无参构造方法");
    }

    public InterfaceDriver(String name){
        super(name);
        System.out.println("司机类的有参构造方法");
    }

    // 重写接口方法
    @Override
    public void theoryTest(){
        System.out.println("司机"+this.getName()+"写了驾照理论习题1000道");
    }

    @Override
    public void fieldDrive(){
        System.out.println("司机"+this.getName()+"会倒车入库，侧方停车");
    }

    @Override
    public void roadDrive(){
        System.out.println("司机"+this.getName()+"行驶在高速上，时速200km/h，撞死了陈君男");
    }

    // 重写抽象方法
    public void work(){
        System.out.println(this.getName()+"的工作内容就是，上班接君男，下班接君男");
    }
}
