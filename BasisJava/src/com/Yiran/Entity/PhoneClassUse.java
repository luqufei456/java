package com.Yiran.Entity;

public class PhoneClassUse {
    public static void main(String[] args){
        // 创建对象
        PhoneClassDefine p1 = new PhoneClassDefine();
        // 输出成员变量
        System.out.println("p1的品牌："+p1.brand); // 默认为null
        System.out.println("p1的价格："+p1.price); // 默认为0
        // 调用成员方法
        p1.call("17671266824");
        p1.call("8888888");

        // 不同对象是否共用成员变量
        PhoneClassDefine p2 = new PhoneClassDefine();

        // 先定义 p1的品牌、价格
        System.out.println("-----不同对象的成员变量是否共享呢-----");
        p1.brand = "小米";
        p1.price = 2000;
        System.out.println("品牌为："+p1.brand);
        System.out.println("品牌为："+p1.price);
        p1.call("17671266824");
        p1.sendMessage("88888888");
        System.out.println("--------------------");
        p2.brand = "华为";
        p2.price = 3000;
        System.out.println("品牌为："+p2.brand);
        System.out.println("品牌为："+p2.price);
        p2.call("17671266824");
        p2.sendMessage("88888888");

    }
}
