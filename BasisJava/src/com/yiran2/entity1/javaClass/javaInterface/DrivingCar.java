package com.yiran2.entity1.javaClass.javaInterface;

/**
 * 开车接口
 *    具备开车功能的类,具备三个方法:理论,场地,路上行驶
 *    创建接口并不需要 class 修饰 因为并不是一个类 而是一个接口
 *
 * 接口中都使用public static final修饰变量 也是常量即无法改变,不可以使用一般的成员变量
 *
 * 接口中只能存在抽象方法
 *
 * 如果不写 public 或 abstract 在编译时会自动加上
 * */

public interface DrivingCar {
    // 接口中都使用public static final修饰变量 也是常量即无法改变
    public static final String speak = "baka！hentai！无路赛！";

    // 所有的成员方法均为public abstract修饰
    // 抽象方法 理论
    void theoryTest();

    // 场地
    public abstract void fieldDrive();

    // 路上行驶
    public abstract void roadDrive();
}
