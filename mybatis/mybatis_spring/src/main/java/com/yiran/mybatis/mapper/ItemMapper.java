package com.yiran.mybatis.mapper;

import com.yiran.mybatis.pojo.Item;

import java.util.List;

public interface ItemMapper {
    /*
    * 之前开发 - 每次均至数据库查询所需数据 - 对数据库开销大
    *   - 数据库优化
    *       sql语句
    *       索引
    *       视图
    *           物化视图 -- 将视图数据创建为一张表
    *       连接池
    *       PL/SQL - 过程化的sql语句，可以在sql语句中进行逻辑处理 - 存储过程
    *
    *   缓存cache - 把查询的数据缓存在内存中，特定时间内，相同查询会直接从内存中取出数据，而不是数据库中查询。
    *       mybatis
    *       hibernate
    *   redis
    *
    *   mybatis缓存cache
    *       一级缓存 - 默认开启
    *           SqlSession级别缓存，即SqlSession存在期间的缓存，SqlSession关闭后缓存清除
    *       二级缓存 -
    *           SqlSessionFactory
    *           在全局中配置
    *               <setting name="cacheEnabled" value="true">
    *           在xxxxMapper.xml中
    *               <cache /> 开启缓存
    *               pojo要实现序列化
    *
    * */

    List<Item> queryItems();

    void insertItem(Item item);
}
