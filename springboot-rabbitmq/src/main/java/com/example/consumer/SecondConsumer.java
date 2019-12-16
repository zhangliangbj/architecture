package com.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangliang
 * @date 2019/12/16 16:36
 */
@Component
@RabbitListener(queues = "SECOND_QUEUE")
public class SecondConsumer {
    @RabbitHandler
    public void process(String msg){
        System.out.println(" second queue received msg : " + msg);
    }

}
