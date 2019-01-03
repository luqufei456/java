package com.yiran.msgType.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

// 局部有序消费者
public class Consumer {
    public static void main(String[] args) throws MQClientException {
        // 声明并初始化一个consumer
        // 需要一个consumer group名字作为构造方法的参数，这里为order_consumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order_consumer");

        // 同样也要设置NameServer地址
        consumer.setNamesrvAddr("localhost:9876");

        // 这里设置的是一个consumer的消费策略
        // CONSUME_FROM_LAST_OFFSET 默认策略，从该队列最尾开始消费，即跳过历史消息
        // CONSUME_FROM_FIRST_OFFSET 从队列最开始开始消费，即历史消息（还储存在broker的）全部消费一遍
        // CONSUME_FROM_TIMESTAMP 从某个时间点开始消费，和setConsumeTimestamp()配合使用，默认是半个小时以前
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        // 设置consumer所订阅的Topic和Tag
        // 比如这个例子中，五种Tag，然后根据循环 i 来进行选择队列写入，那么就指定只有5个队列，读的时候，只选择tag之一。
        // 这样就能保证顺序。例如 queue1  0，5,10，然后tag都为 TagA。
        consumer.subscribe("TopicTest", "TagA");

        // 设置一个Listener，主要进行消息的逻辑处理
        // 注意这里使用的是MessageListenerOrderly这个接口
        consumer.registerMessageListener(new MessageListenerOrderly() {

            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext context) {

                for (MessageExt ext:list){
                    System.out.println(new String(ext.getBody()));
                }

                //返回消费状态
                //SUCCESS 消费成功
                //SUSPEND_CURRENT_QUEUE_A_MOMENT 消费失败，暂停当前队列的消费
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        //调用start()方法启动consumer
        consumer.start();

        System.out.println("Consumer Started.");
    }
}
