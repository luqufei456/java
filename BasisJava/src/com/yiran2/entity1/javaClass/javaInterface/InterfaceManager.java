package com.yiran2.entity1.javaClass.javaInterface;

/**
 * 经理类
 *    经理需要具备开车的功能,则实现开车接口
 * */

public class InterfaceManager extends InterfaceEmployee implements DrivingCar{
    public InterfaceManager(){
        System.out.println("经理类的无参构造方法");
    }

    public InterfaceManager(String name){
        super(name);
        System.out.println("经理类的有参构造方法");
    }

    // 使用方法重写时,子类的访问权限必须大于或等于父类
    //让经理类实现开车功能接口,重写三个方法,具备开车功能
    @Override
    public void theoryTest(){
        System.out.println("经理"+this.getName()+"写了驾照理论习题500道");
    }

    @Override
    public void fieldDrive(){
        System.out.println("经理"+this.getName()+"会倒车入库，不会侧方停车");
    }

    @Override
    public void roadDrive(){
        System.out.println("经理"+this.getName()+"行驶在高速上，时速60km/h，慢的一比");
    }

    // 重写父类抽象方法
    public void work(){
        System.out.println(this.getName()+"整天无所事事，到处bb员工");
    }
}
