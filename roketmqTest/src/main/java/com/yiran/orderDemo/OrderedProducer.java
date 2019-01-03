package com.yiran.orderDemo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

public class OrderedProducer {
    public static void main(String[] args) throws Exception {
        // 这里需要名称服务器的环境变量。不设置会报错
        // 使用生产者组名实例化
        MQProducer producer = new DefaultMQProducer("orderGroup1");
        // 启动实例
        producer.start();
        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 100; i++) {
            int orderId = i % 10;
            // 创建一个消息实例，指定Topic、Tag和Body。
            Message msg = new Message("TopicTest",tags[i%tags.length],"KEY"+i,
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                // MessageQueue 这个topic中存在的所有消息队列，可以指定用哪个消息队列来发送消息 o的值就是orderId
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Integer id = (Integer) o;
                    int index = id % list.size();
                    // 这里根据前面的id对队列集合大小求余来返回所对应的队列
                    return list.get(index);
                }
            },orderId);

            // 输出出来的queueId，代表着队列的id号，从0-n-1，n-1为自己设置的队列数量
            System.out.println(sendResult);
        }

        producer.shutdown();
    }
}
