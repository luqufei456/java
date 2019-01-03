package com.travelsky.yiran.helloWorld;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;


public class Recv {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException,TimeoutException {
        // 创建连接  连接服务器
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 为什么这里又声明了一次？ 因为你不确定是先运行 Send 还是 Recv，保证队列存在不会有什么错误
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // 保持等待消息状态，按ctrl+c退出
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        // 因为 handleDelivery 方法是一个空方法，所以要重写
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties,byte[] body)
            throws UnsupportedEncodingException{
                String message = new String(body,"UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        // 队列名，确认回执为true，接收者
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
