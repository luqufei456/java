package com.yiran.sql92;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class SQL92Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("SQL92Producer-1");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        for (int i = 0; i < 10; i++) {
            Message msg = new Message(
                    "TopicTest",
                    "TagA",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // 设置一个属性
            msg.putUserProperty("age",String.valueOf(i));
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
            // 关闭，因为是同步阻塞的，所以可以在代码中关闭producer
            producer.shutdown();
        }
    }
}
