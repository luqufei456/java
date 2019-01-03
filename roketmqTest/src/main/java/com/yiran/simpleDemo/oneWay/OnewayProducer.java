package com.yiran.simpleDemo.oneWay;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class OnewayProducer {
    public static void main(String[] args) throws Exception {
        // 用生产者组名称实例化，请命名唯一的组名
        DefaultMQProducer producer = new DefaultMQProducer("syncProducerGroup-1");
        // 指定名称服务器地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动实例
        producer.start();
        for (int i = 0; i < 100; i++) {
            // 创建一个消息实例，指定Topic、Tag和Body。
            Message msg = new Message(
                    // http://127.0.0.1:8083/#/topic，先在插件中新建这个Topic，否则会报错，因为不存在。
                    // Message 所属的 Topic
                    "TopicTest",
                    // Message Tag 可理解为 Gmail 中的标签，对消息进行再归类，
                    // 方便 Consumer 指定过滤条件在 MQ 服务器过滤
                    "TagA",
                    // Message Body 可以是任何二进制形式的数据， MQ 不做任何干预
                    // 需要 Producer 与 Consumer 协商好一致的序列化和反序列化方式
                    // RemotingHelper.DEFAULT_CHARSET 使用默认编码
                    ("hello RocketMQ"+i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // 调用 sendOneway 方法，和同步发送消息的唯一区别就在这里。不接收返回值
            producer.sendOneway(msg);
        }
        // 关闭实例
        producer.shutdown();
    }
}
