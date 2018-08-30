package com.yiran.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {
    private Integer itemId;
    private String itemName;
    private Double itemPrice;
    private String itemInfo;
    // 一个商品可以在多个订单详情中
    private List<OrderDetail> orderDetailList;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemInfo='" + itemInfo + '\'' +
                ", orderDetailList=" + orderDetailList +
                '}';
    }
}
