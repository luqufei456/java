package com.yiran2.entity1.receiptsWork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 超市购物小票类
 * */

public class ShoppingReceipt {
    // 将集合定义为成员变量，用于存储所有商品对象
    private ArrayList<GoodsClass> goodsArr = new ArrayList<GoodsClass>();
    // 定义实际付款
    private double payment = 0;
    // 定义总金额
    private double totalMoney = 0.0;

    public static void main(String[] args){
        ShoppingReceipt sr = new ShoppingReceipt();

        // 为集合准备数据
        sr.initData();

        System.out.println("--------欢迎使用超市小票系统--------");

        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        // for (;;){} 这是for的死循环
        while (true){
            System.out.println();
            System.out.println("1 输入购买数量");
            System.out.println("2 打印购物小票");
            System.out.println("3 退出");
            System.out.print("请输入您要进行的操作：");
            String choose = sc.next();

            // 使用switch给出操作选择，1 购买数量 2 打印小票 3 退出
            switch (choose){
                case "1":
                    // 购买数量
                    System.out.println("给所有数据量赋值");
                    sr.enterNum();
                    break;
                case "2":
                    // 打印购物小票
                    System.out.println("打印购物小票");
                    sr.printReceipt();
                    break;
                case "3":
                    // 退出程序
                    System.out.println("欢迎下次光临");
                    System.exit(0);
                    break;
                default:
                    System.out.println("请输入正确的数字：");
                    break;
            }
        }
    }

    // 用于创建多个商品对象
    public void initData(){
        GoodsClass milk = new GoodsClass("蒙牛优酸乳","10086",2.5,0,"瓶",0);
        GoodsClass bread = new GoodsClass("盼盼法式小面包","10087",5,0,"包",0);
        goodsArr.add(milk);
        goodsArr.add(bread);
    }

    // 定义方法为所有数据赋值数量和金额
    public void enterNum(){
        // 键盘录入接收商品数量
        Scanner sc = new Scanner(System.in);

        // 遍历集合
        for (int i = 0;i < goodsArr.size();i++){
            // 获取集合中每一个商品对象
            GoodsClass goods = goodsArr.get(i);

            //  获取商品名 然后获取用户输入数量
            String name = goods.getName();
            System.out.print("请输入"+name+"的购买数量：");
            int goodsnum = sc.nextInt();

            // 根据数量与单价计算总额
            double goodsMoney = goods.getPrice() * goodsnum;

            // 给数量与金额赋值
            goods.setNumber(goodsnum);
            goods.setMoney(goodsMoney);
            totalMoney += goodsMoney;
        }
        System.out.println("总金额为"+totalMoney);
        System.out.print("请输入实付金额:");
        payment = sc.nextDouble();
    }

    // 定义方法完成打印小票功能
    public void printReceipt(){
        // 票头
        System.out.println("    欢迎光临");
        System.out.println("品名\t售价\t数量\t单位\t金额");
        System.out.println("------------------------------------------");
        // 票体
        // 定义变量，记录 商品总量
        int totalNum = 0;
        // 使用循环得到每种商品的信息 将其输出 加入到总量中
        int goodsSize = 0;
        for (int i = 0;i < goodsArr.size();i++){
            GoodsClass goods = goodsArr.get(i);
            if (goods.getNumber() != 0){
                System.out.println(goods.getName()+"\t"+goods.getId()+"\t"+goods.getPrice()+"\t"+goods.getNumber()+"\t"+goods.getUnit()+"\t"+goods.getMoney());

                // 累加商品总量
                totalNum += goods.getNumber();
                goodsSize++;
            }
        }

        System.out.println("------------------------------------------");
        // 票脚
        System.out.println("共"+goodsSize+"种商品");
        System.out.println("共"+totalNum+"件商品");
        System.out.println("收您"+payment+"元");
        // 定义找零
        double returnMoney = payment - totalMoney;
        System.out.println("找零"+returnMoney+"元");
    }

}
