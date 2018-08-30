package com.yiran.mybatis.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/* 订单 */
public class Order implements Serializable {
    private Integer orderId;
    private Integer totalNum;
    private Timestamp orderTime;
    private Double totalPrice;
    // 一个订单对应一个用户，和用户的一个地址
    private User user;
    private Address address;
    // 一个订单可以有多个商品(订单)详情
    private List<OrderDetail> orderDetailList;

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", totalNum=" + totalNum +
                ", orderTime=" + orderTime +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                ", address=" + address +
                ", orderDetailList=" + orderDetailList +
                '}';
    }
}
