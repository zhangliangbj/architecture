package com.example.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangliang
 * @date 2019/12/14 14:36
 */
public class ConsumerTest {

    private static final String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private static final String QUEUE_NAME = "SIMPLE_QUEUE";
    private static final String QUEUEONE_NAME = "EASY_QUEUE";
    private static final String QUEUETWO_NAME = "HARD_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        //连接IP
        factory.setHost("127.0.0.1");
        //连接端口
        factory.setPort(5672);
        //虚拟机
        factory.setVirtualHost("/");
        //用户
        factory.setUsername("guest");
        factory.setPassword("guest");

        //建立连接
        Connection conn = factory.newConnection();
        //创建消息通道
        Channel channel = conn.createChannel();
//        Channel channel1 = conn.createChannel();
//        Channel channel2 = conn.createChannel();

        //声明交换机
        //String exchange，String type，boolean durable，boolean autoDelete,Map<String, Object> arguments
        channel.exchangeDeclare(EXCHANGE_NAME,"direct",false,false,null);

        //声明队列
        //String queue,boolean durable,boolean exclusive,boolean autoDelete,Map<String, Object> arguments
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        System.out.println("Waiting for message");

//        //声明队列1
//        //String queue,boolean durable,boolean exclusive,boolean autoDelete,Map<String, Object> arguments
//        channel1.queueDeclare(QUEUEONE_NAME,false,false,false,null);
//        System.out.println("Waiting for message1");
//
//        //声明队列1
//        //String queue,boolean durable,boolean exclusive,boolean autoDelete,Map<String, Object> arguments
//        channel2.queueDeclare(QUEUETWO_NAME,false,false,false,null);
//        System.out.println("Waiting for message2");

        //绑定队列和交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

//        channel1.queueBind(QUEUEONE_NAME,EXCHANGE_NAME,"zl.good");
//
//        channel2.queueBind(QUEUETWO_NAME,EXCHANGE_NAME,"zl.good");

        //创建消费者
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"UTF-8");
                System.out.println("Received message : '" + msg + "'");
                System.out.println("consumerTag : " + consumerTag );
                System.out.println("deliveryTag : " + envelope.getDeliveryTag() );
            }
        };

        //开始获取消息
        //String queue，boolean autoAck，Consumer callback
        channel.basicConsume(QUEUE_NAME,true,consumer);

    }

}
