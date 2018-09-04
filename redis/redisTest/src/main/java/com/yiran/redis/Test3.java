package com.yiran.redis;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/*
* 测试链接jedis集群
* */
public class Test3 {
    public static void main(String[] args) throws Exception {
        //创建jedisCluster对象
        // 出现Could not get a resource from the pool
        // connect timed out
        // 防火墙问题，可以临时关闭防火墙
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.13.25", 6379));
        nodes.add(new HostAndPort("192.168.13.25", 6380));
        nodes.add(new HostAndPort("192.168.13.25", 6381));
        nodes.add(new HostAndPort("192.168.13.25", 6382));
        nodes.add(new HostAndPort("192.168.13.25", 6383));
        nodes.add(new HostAndPort("192.168.13.25", 6384));
        JedisCluster jedisCluster = new JedisCluster(nodes);
        //操作数据库
        jedisCluster.set("name", "yiran");
        String str = jedisCluster.get("name");
        System.out.println(str);
        //关闭资源
        jedisCluster.close();
    }
}
