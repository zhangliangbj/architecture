package com.example.ttl;

import com.example.utils.ResourceUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangliang
 * @date 2019/12/16 10:29
 */
public class TTLProducer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(ResourceUtil.getKey("rabbitmq.uri"));

        //建立连接
        Connection conn = factory.newConnection();
        //创建消息通道
        Channel channel = conn.createChannel();

        String msg = "Hello world,Rabbit MQ，DLX MSG";

        //通过队列属性设置消息过期时间
        Map<String,Object> argss = new HashMap<>();
        argss.put("x-message-ttl",6000);

        //声明队列（默认交换机AMQP）
        channel.queueDeclare("TEST_TTL_QUEUE",false,false,false,argss);

        //对每条消息设置过期时间
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .deliveryMode(2)//持久化消息
                .contentEncoding("UTF-8")
                .expiration("10000") //TTL
                .build();

        //如果两种方式都设置消息过期时间了，将以较小的数值为准

        //发送消息
        channel.basicPublish("","TEST_TTL_QUEUE",properties,msg.getBytes());
        channel.close();
        conn.close();

    }


}
