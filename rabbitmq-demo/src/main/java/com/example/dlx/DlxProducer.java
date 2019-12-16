package com.example.dlx;

import com.example.utils.ResourceUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author zhangliang
 * @date 2019/12/16 11:26
 */
public class DlxProducer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(ResourceUtil.getKey("rabbitmq.uri"));

        //建立连接
        Connection conn = factory.newConnection();
        //创建消息通道
        Channel channel = conn.createChannel();

        String msg = "hello ,DLX message";

        //设置属性，消息10秒后过期
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .deliveryMode(2)
                .contentEncoding("UTF-8")
                .expiration("10000")//TTL
                .build();

        //发送消息
        for (int i = 0;i<10;i++){
            channel.basicPublish("","TEST_DLX_QUEUE",properties,msg.getBytes());
        }

        channel.close();
        conn.close();

    }


}
