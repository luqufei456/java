package cn.yiran.web.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderInfo {
    private Map<Integer,Cart> orderCarts = new HashMap<>();
    private String orderId;

    public Map<Integer, Cart> getOrderCarts() {
        return orderCarts;
    }

    public void setOrderCarts(Map<Integer, Cart> orderCarts) {
        this.orderCarts = orderCarts;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
