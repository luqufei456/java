package com.yiran2.entity1.receiptsWork;

/**
 * 商品项类
 *
 * 定义商品项类:
 * 		名称,货号,单价,数量,计价单位,金额
 * */

public class GoodsClass {
    // 名称
    private String name;
    // 货号
    private String id;
    // 单价
    private double price;
    // 数量
    private int number;
    // 计价单位
    private String unit;
    // 金额
    private double money;

    // 构造方法
    public GoodsClass(){}

    public GoodsClass(String name, String id, double price, int number, String unit, double money){
        this.name = name;
        this.id = id;
        this.price = price;
        this.number = number;
        this.unit = unit;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
