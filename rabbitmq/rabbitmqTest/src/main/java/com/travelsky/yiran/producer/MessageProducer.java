package com.travelsky.yiran.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.IOException;

@Service
public class MessageProducer {
    private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    // 通过配置将template链接connect-factory并注入
    @Resource(name="amqpTemplate")
    private AmqpTemplate amqpTemplate;

    @Resource(name="amqpTemplate2")
    private AmqpTemplate amqpTemplate2;

    public void sendMessage(Object message) throws IOException {
        logger.info("to send message:{}",message);
        amqpTemplate.convertAndSend("queueTestKey",message);
        amqpTemplate.convertAndSend("queueTestChris",message);
        amqpTemplate2.convertAndSend("shijj.xxxx.wsdwd",message);
    }
}
