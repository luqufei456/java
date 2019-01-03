package com.travelsky.yiran.workQueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class NewTask {
    private final static String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws IOException,TimeoutException {
        // 创建连接 连接服务器
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 声明队列，发送消息 是持久队列、不是独有队列、不会自动删除、队列其他属性设置为null
        channel.queueDeclare(TASK_QUEUE_NAME,true,false,false,null);

        // 这里有改变，这里在idea运行先模拟一下，new String[] {"First","message."}...
        String message = getMessage(new String[] {"Fifth","message....."});

        // "" 空字符串代表默认交换机，路由关键字和队列名一样，会被默认交换机发送，发送的是字节类型数组
        // 第二个参数代表 消息持久化
        channel.basicPublish("",TASK_QUEUE_NAME,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        // 关闭通道和连接
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
