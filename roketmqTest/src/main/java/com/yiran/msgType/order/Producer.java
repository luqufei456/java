package com.yiran.msgType.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;


// 局部有序消息发送
public class Producer {
    public static void main(String[] args) throws Exception {
        // 声明并初始化一个producer
        // 需要一个producer group名字作为构造方法的参数，这里为order_producer
        DefaultMQProducer producer = new DefaultMQProducer("order_producer");

        // 设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用 ; 分隔
        // NameServer的地址必须有，但是也可以通过环境变量的方式设置，不一定非得写死在代码里
        producer.setNamesrvAddr("localhost:9876");

        producer.setDefaultTopicQueueNums(5);

        // 调用start()方法启动一个producer实例
        producer.start();

        // 自定义一个tag数组
        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};

        // 发送10条消息到Topic为TopicTest，tag为tags数组按顺序取值，
        // key值为“KEY”拼接上i的值，消息内容为“Hello RocketMQ”拼接上i的值
        for (int i = 0; i < 10; i++) {
            int orderId = i % 10;
            Message msg = new Message(
                    "TopicTest",
                    tags[i % tags.length],
                    "KEY" + i,
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );

            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                // 选择发送消息的队列
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    // arg的值其实就是orderId
                    Integer id = (Integer) o;

                    // mqs是队列集合，也就是topic所对应的所有队列
                    int index = id % list.size();

                    // 这里根据前面的id对队列集合大小求余来返回所对应的队列
                    return list.get(index);
                }
            },orderId);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
