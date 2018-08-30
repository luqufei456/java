package com.yiran.mybatis.pojo;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private Integer detaiId;
    private Integer itemNum;
    // 一个商品详情对应一个订单
    // 对应一个商品
    private Item item;
    private Order order;

    public Integer getDetaiId() {
        return detaiId;
    }

    public void setDetaiId(Integer detaiId) {
        this.detaiId = detaiId;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "detaiId=" + detaiId +
                ", itemNum=" + itemNum +
                ", item=" + item +
                ", order=" + order +
                '}';
    }
}
