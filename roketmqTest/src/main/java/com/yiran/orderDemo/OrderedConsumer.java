package com.yiran.orderDemo;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class OrderedConsumer {
    public static void main(String[] args) throws Exception {
        // 这里需要名称服务器的环境变量。不设置会报错
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("OrderedConsumer-1");
        // 设置从哪里消费 -- 从一开始开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 订阅，订阅 Tag为 Tag A D C 的消息
        consumer.subscribe("TopicTest","TagA || TagC || TagD");
        // 这里是注册的有序消息侦听器
        consumer.registerMessageListener(new MessageListenerOrderly() {
            // AtomicLong是作用是对长整形进行原子操作
            AtomicLong consumeTimes = new AtomicLong(0);

            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                // 消费有序的context，不设置自动提交的话，消息会一直重复回到topic，然后重复被消费。
                consumeOrderlyContext.setAutoCommit(true);
                System.out.println(Thread.currentThread().getName()+" Receive New Messages: " + list + "%n");
                // 自增，并且获得
                this.consumeTimes.incrementAndGet();
                if ((this.consumeTimes.get() % 2) == 0) {
                    return ConsumeOrderlyStatus.SUCCESS;
                } else if ((this.consumeTimes.get() % 3) == 0) {
                    return ConsumeOrderlyStatus.ROLLBACK;
                } else if ((this.consumeTimes.get() % 4) == 0) {
                    return ConsumeOrderlyStatus.COMMIT;
                } else if ((this.consumeTimes.get() % 5) == 0) {
                    // 设置挂起当前队列的时间
                    consumeOrderlyContext.setSuspendCurrentQueueTimeMillis(3000);
                    return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();
        System.out.println("Consumer Started.%n");
    }
}
