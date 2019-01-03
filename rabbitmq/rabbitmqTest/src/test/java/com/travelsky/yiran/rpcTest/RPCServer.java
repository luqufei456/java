package com.travelsky.yiran.rpcTest;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RPCServer {
    private static final String RPC_QUEUE_NAME = "rpc_queue";

    private static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        // n = 3时，1 1 2
        int a = 1; // 第一个数
        int b = 1; // 第二个数
        int ret = 0; // 第三个数，还没求和
        for (int i = 3; i <= n; i++){
            ret = a + b;
            a = b;
            b = ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = null;
        try {
            connection = factory.newConnection();
            // 创建通道
            final Channel channel = connection.createChannel();

            // 声明队列，不是持久队列、不是独有队列、不会自动删除、队列其他属性设置为null
            channel.queueDeclare(RPC_QUEUE_NAME,false,false,false,null);
            // 清空队列，将所有不处于等待 确认回执(acknowledgment) 状态的消息全部移除。
            channel.queuePurge(RPC_QUEUE_NAME);
            // 公平调度，在工作人员处理并确认前一条消息之前，不要向其发送新消息。相反，它将把它发送给下一个不太忙的工人。
            channel.basicQos(1);

            System.out.println(" [x] Awaiting RPC requests");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    // 根据消息的其他属性中的correlationId，来定义返回消息的其他属性
                    AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                            .Builder()
                            .correlationId(properties.getCorrelationId())
                            .build();
                    String response = "";

                    try {
                        String message = new String(body,"UTF-8");
                        int n = Integer.parseInt(message);

                        System.out.println(" [.] fib(" + message + ")");
                        response += fib(n);
                    } catch (RuntimeException e) {
                        // 运行时可能因为发送的 n 的值引发异常
                        System.out.println(" [.] " + e.toString());
                    } finally {
                        // 发送消息，默认交换机，routingKey值为要回复的队列名，由客户端设置，其他属性保证唯一的correlationId一致，内容
                        channel.basicPublish("",properties.getReplyTo(),replyProps,response.getBytes());
                        // 确认回执，只确认当前交付的消息
                        channel.basicAck(envelope.getDeliveryTag(),false);
                        // RabbitMq使用者工作线程通知RPC服务器所有者线程
                        synchronized (this) {
                            // 唤醒在此对象监视器上等待的单个线程
                            this.notify();
                        }
                    }
                }
            };
            // 此方法告知服务器开启一个 "消费者"，不自动ack，需要使用channel.ack、channel.nack、channel.basicReject 进行消息应答
            channel.basicConsume(RPC_QUEUE_NAME,false,consumer);
            // 等待并准备使用来自RPC客户机的消息。
            while (true) {
                synchronized (consumer) {
                    try {
                        consumer.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException _ignore){}
            }
        }
    }
}
