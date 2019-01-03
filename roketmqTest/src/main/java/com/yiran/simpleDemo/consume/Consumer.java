package com.yiran.simpleDemo.consume;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class Consumer {
    public static void main(String[] args) throws InterruptedException, MQClientException {
        // 使用指定的消费者组名称实例化。请命名为唯一的组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer-1");
        // 指定名称服务器的地址
        consumer.setNamesrvAddr("172.25.8.40:9876");
        // 订阅更多要消费的topic
        consumer.subscribe("testtocpic", "*");
        // 注册回调函数，以便在从代理获取的消息到达时执行。
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), list);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动消费者实例
        consumer.start();
        System.out.println("Consumer Started.%n");
        /*consumer.shutdown();*/
    }
}
