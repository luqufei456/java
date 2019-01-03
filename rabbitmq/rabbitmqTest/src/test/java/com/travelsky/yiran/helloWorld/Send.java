package com.travelsky.yiran.helloWorld;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException,TimeoutException {
        // 创建连接 连接服务器
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 声明队列，发送消息 不是持久队列、不是独有队列、不会自动删除、队列其他属性设置为null
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = "Hello World";
        // "" 空字符串代表默认交换机，路由关键字和队列名一样，会被默认交换机发送，发送的是字节类型数组
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        // 关闭通道和连接
        channel.close();
        connection.close();
    }
}
