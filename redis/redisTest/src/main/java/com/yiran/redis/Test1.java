package com.yiran.redis;

import redis.clients.jedis.Jedis;

public class Test1 {
    public static void main(String [] args){
        //创建Jedis对象，传递两个参数：第一个host为redis服务器的名称，
        // 第二个为redis服务器的端口号
        Jedis jedis = new Jedis("192.168.13.25", 6379);
        //进行设值操作
        jedis.set("name","依然");
        //从redis中取值
        String name = jedis.get("name");
        System.out.println("name:"+name);
    }
}
