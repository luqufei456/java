package com.yiran.Scheduled;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

// 定时发送消息 - 生产者
public class ScheduledMessageProducer {
    public static void main(String[] args) throws Exception {
        // 实例化生产者，发送定时消息
        DefaultMQProducer producer = new DefaultMQProducer("ScheduledMessageProducer-1");
        // 启动生产者
        producer.start();

        for (int i = 0; i < 10; i++) {
            Message msg = new Message(
                    "TopicTest",
                    ("Hello World"+i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // 设置延时级别
            msg.setDelayTimeLevel(3);
            producer.send(msg);
        }
        // 关闭生产者
        producer.shutdown();
    }
}
