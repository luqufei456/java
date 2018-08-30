package com.yiran.mybatis.mapper;

import com.yiran.mybatis.pojo.Order;

import java.util.List;

public interface OrderMapper {
    Order queryOrderUserAddress(Integer orderId);

    // 装货 默认关联查询 - 若为多条数据
    // 应定义为数组或者集合，返回的数据虽然是同一个订单，但是多条数据被mybatis定义为多个返回集
    List<Order> queryOrderItemsByOrderId(Integer orderId);

    // 懒加载机制 -- 关联对象不会一并查询，而是使用时才会进行关联查询
    //      - 执行时并不会到数据库中直接查询数据
    //      - 当使用对象数据时，才会去数据库中查询数据
    Order queryOrderItemByOrderIdLazy(Integer orderId);

    Order queryOrderItemsUserAddressByOrderId(Integer orderId);

}
