package com.yiran.simpleDemo.async;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        // 用生产者组名称实例化。
        DefaultMQProducer producer = new DefaultMQProducer("asyncProducerGroup-1");
        // 指定名称服务器地址
        producer.setNamesrvAddr("172.25.8.40:9876");
        // 启动实例
        producer.start();
        // 设置发送异步失败时的重试时间 0 估计代表不重试
        producer.setRetryTimesWhenSendAsyncFailed(1000);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            // 创建一个消息实例，指定Topic、Tag和Body。
            Message msg = new Message(
                    "testtocpic",
                    "TagA",
                    "OrderID188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                }
                @Override
                public void onException(Throwable throwable) {
                    System.out.printf("%-10d Exception %s %n", index, throwable);
                    throwable.printStackTrace();
                }
            });
            // 一旦生产者实例不再使用，就关闭它。
            // 注意，异步发送这里不能关闭，可能是发送完消息之后线程还在准备接收回复，这时候关闭了生产者，会报错
            // producer.shutdown();
        }
    }
}