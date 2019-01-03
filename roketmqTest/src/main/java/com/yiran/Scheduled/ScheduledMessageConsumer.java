package com.yiran.Scheduled;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class ScheduledMessageConsumer {
    public static void main(String[] args) throws Exception {
        // 实例化消息消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ScheduledMessageConsumer-1");
        // 订阅
        consumer.subscribe("TopicTest","*");
        // 注册消息监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt message : list) {
                    // message.getStoreTimestamp() 消息存储时间戳
                    // message.getBornTimestamp() 消息产生时间戳
                    // 可以发现，两者之差几乎就等于10s，官网的例子其实有点问题，估计是版本不对应导致的。
                    // 在4.3版本中，延时发送的消息，会先产生，然后到时间了发送给broker，然后被存储起来(根据时间戳猜测)
                    System.out.println("Receive message[msgId=" + message.getMsgId() + "] "
                            + (message.getStoreTimestamp() - message.getBornTimestamp()) + "ms later");
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("Consumer Started.%n");
    }
}
