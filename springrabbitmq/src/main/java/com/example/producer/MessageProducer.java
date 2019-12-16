package com.example.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * @author zhangliang
 * @date 2019/12/16 15:12
 */
@Service
public class MessageProducer {

    private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    @Qualifier("amqpTemplate")
    private AmqpTemplate amqpTemplate;

    @Qualifier("amqpTemplate2")
    private AmqpTemplate amqpTemplate2;

    /**
     * 三种交换机的使用
     */
    public void sendMessage(Object message){
        logger.info("send message:" + message);

        // amqpTemplate 默认交换机 MY_DIRECT_EXCHANGE
        // amqpTemplate2 默认交换机 MY_TOPIC_EXCHANGE

        //Exchange 为direct 模式，直接指定routingKey
        amqpTemplate.convertAndSend("FirstKey","[Direct,FirstKey]"+message);
        amqpTemplate.convertAndSend("SecondKey","[Direct,SecondKey]"+message);

        //Exchange模式为topic，通过topic匹配关系该主题的队列
        amqpTemplate2.convertAndSend("msg.Third.send","[Topic,msg.Third.send]"+message);

        // 广播消息，与Exchange绑定的所有队列都会收到消息，routingKey为空
        amqpTemplate2.convertAndSend("MY_FANOUT_EXCHANGE",null,"[Fanout] "+message);

    }

}
