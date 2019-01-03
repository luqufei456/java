package com.travelsky.yiran.publishSubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EmitLog {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException,TimeoutException {
        // 创建连接 连接服务器
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 声明交换机，名称、类型
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        String message = getMessage(new String[] {"Fifth","message....."});

        // logs交换机，路由关键字 ""
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());

        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();

    }

    private static String getMessage(String[] strings) {
        // 将字符串数组使用joinStrings方法串成一个字符串。
        if (strings.length < 1) {
            return "Hello World";
        }
        return joinStrings(strings," ");
    }

    private static String joinStrings(String[] strings,String delimiter) {
        int length = strings.length;
        if(length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++){
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}
