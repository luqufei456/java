package com.travelsky.yiran.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

// 第一个消费者，接受direct的消息, 他的exchange为exchangeTest,  routing key为queueTestKey
public class MessageConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @Override
    public void onMessage(Message message) {
        logger.info("consumer receive message------->:{}",message);
    }
}
