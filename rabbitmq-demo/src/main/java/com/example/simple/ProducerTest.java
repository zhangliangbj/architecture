package com.example.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangliang
 * @date 2019/12/14 14:36
 */
public class ProducerTest {

    private static final String EXCHANGE_NAME = "SIMPLE_EXCHANGE";

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

        //发送消息
        String msg = "Hello world,Rabbit MQ";

        //String exchange,String routingKey,BasicProperties props,byte[] body
        channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());
        channel.close();
        conn.close();


    }

}
