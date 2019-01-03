package com.travelsky.yiran.workQueues;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Worker {
    private final static String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws IOException,TimeoutException {
        // 创建连接  连接服务器
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        // 为什么这里又声明了一次？ 因为你不确定是先运行 Send 还是 Recv，保证队列存在不会有什么错误
        channel.queueDeclare(TASK_QUEUE_NAME,true,false,false,null);
        // 保持等待消息状态，按ctrl+c退出
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        // 一次只接收一条未打包的消息(见 2.6 公平调度)
        channel.basicQos(1);

        // 因为 handleDelivery 方法是一个空方法，所以要重写
        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties,byte[] body)
                    throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } catch (InterruptedException e){
                    System.out.println(" [x] Done");
                    // 拒绝输入消息，只拒绝当前交付的消息false，只是拒绝消息，而不是将消息丢弃true
                    channel.basicNack(envelope.getDeliveryTag(), false, true);
                }
                // 在处理完的最后，发送确认处理完成。 false代表只确认当前交付的消息，而不是所有消息
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        // 队列名，需要显式确认回执，接收者
        boolean autoAck = false;
        channel.basicConsume(TASK_QUEUE_NAME,autoAck,consumer);
    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
