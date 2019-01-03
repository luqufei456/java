package com.yiran.broadcasting;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

// 广播示例，生产者
public class BroadcastProducer {
    public static void main(String[] args) throws Exception {
        // 声明并初始化一个producer  启动
        DefaultMQProducer producer = new DefaultMQProducer("BroadcastProducer-1");
        producer.start();

        for (int i = 0; i < 10; i++) {
            Message msg = new Message(
                    "TopicTest",
                    "TagA",
                    "OrderID188",
                    "Hello World".getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // 发送消息
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        }
        // 关闭
        producer.shutdown();
    }
}
