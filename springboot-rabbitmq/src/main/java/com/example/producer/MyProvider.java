package com.example.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangliang
 * @date 2019/12/16 16:38
 */
@Component
public class MyProvider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        amqpTemplate.convertAndSend("","FIRST_QUEUE","-------- a direct msg");

        amqpTemplate.convertAndSend("TOPIC_EXCHANGE","shanghai.gupao.teacher","-------- a topic msg : shanghai.gupao.teacher");
        amqpTemplate.convertAndSend("TOPIC_EXCHANGE","changsha.gupao.student","-------- a topic msg : changsha.gupao.student");

        amqpTemplate.convertAndSend("FANOUT_EXCHANGE","","-------- a fanout msg");
    }


}
