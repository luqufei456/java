package com.yiran2.entity1.javaClass.javaInterface;

/**
 * 接口使用的测试类
 * */

public class InterfaceTest {
    public static void main(String[] args){
        // 创建实现了接口的经理对象，调用方法
        InterfaceManager zjz = new InterfaceManager("周经智");
        zjz.theoryTest();
        zjz.fieldDrive();
        zjz.roadDrive();
        zjz.work();
        // 访问接口静态常量的几种方法
        System.out.println(zjz.getName()+"说："+zjz.speak);
        System.out.println(zjz.getName()+"说："+InterfaceManager.speak);
        System.out.println(zjz.getName()+"说："+DrivingCar.speak);
        System.out.println();

        // 创建司机对象，调用方法
        InterfaceDriver gel = new InterfaceDriver("杨逸晨");
        gel.theoryTest();
        gel.fieldDrive();
        gel.roadDrive();
        gel.work();
        System.out.println();

        // 创建服务员对象，调用方法
        InterfaceWaiter paojie = new InterfaceWaiter("韩志文");
        // 服务员类没有实现接口方法，所以无法使用
        /*paojie.theoryTest();
        paojie.fieldDrive();
        paojie.roadDrive();*/
        paojie.work();
    }
}
