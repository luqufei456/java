package com.travelsky.yiran.rpcTest;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

public class RPCClient {
    private Connection connection;
    private Channel channel;
    private String requestQueueName = "rpc_queue";

    // 构造方法创建一个链接，一个通道
    public RPCClient() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        connection = factory.newConnection();
        channel = connection.createChannel();
    }

    // 由于使用的是默认交换机，所以会省掉binding这个环节，根据队列名接收消息
    public String call(String message) throws IOException,InterruptedException {
        // 在这里，我们首先生成一个唯一的相关id号并保存它——我们在RpcConsumer中实现的handleDelivery将使用这个值捕获适当的响应。
        final String corrId = UUID.randomUUID().toString();

        // 然后，我们为应答创建专用的独占队列并订阅它。
        String replyQueueName = channel.queueDeclare().getQueue();
        AMQP.BasicProperties props = new AMQP.BasicProperties.
                Builder().
                correlationId(corrId).
                replyTo(replyQueueName).
                build();
        // 接下来，我们发布带有两个属性的请求消息:replyTo和correlationId。
        channel.basicPublish("",requestQueueName,props,message.getBytes("UTF-8"));

        // 因为我们的使用者交付处理发生在一个单独的线程中，所以我们需要在响应到达之前挂起主线程。
        // 使用BlockingQueue是一种可能的解决方案。(基于链表的阻塞队列)
        // 这里我们创建的ArrayBlockingQueue的容量设置为1，因为我们只需要等待一个响应。
        final BlockingQueue<String> response = new ArrayBlockingQueue<String>(1);

        // 启动该队列的消费者，开始准备接收消息，返回队列名
        String ctag = channel.basicConsume(replyQueueName,true,new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // handleDelivery方法执行一个非常简单的工作，对于使用的每个响应消息，它检查correlationId是否是我们正在寻找的。
                if (properties.getCorrelationId().equals(corrId)) {
                    // 如果是，它将响应放入BlockingQueue。同时主线程正在等待从BlockingQueue中获取它的响应。
                    response.offer(new String(body, "UTF-8"));
                }
            }
        });
        // 最后，我们将响应返回给用户。
        String result = response.take();
        // 结束该队列的消费者
        channel.basicCancel(ctag);
        return result;
    }

    public void close() throws IOException {
        connection.close();
    }

    public static void main(String[] args) {
        RPCClient fibonacciRpc = null;
        String response = null;
        try {
            fibonacciRpc = new RPCClient();

            for (int i = 0; i < 32; i++) {
                String i_str = Integer.toString(i);
                System.out.println(" [x] Requesting fib(" + i_str + ")");
                response = fibonacciRpc.call(i_str);
                System.out.println(" [.] Got '" + response + "'");
            }
        } catch (IOException | TimeoutException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (fibonacciRpc != null) {
                try {
                    fibonacciRpc.close();
                } catch (IOException _ignore) {}
            }
        }
    }

}
