package com.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangliang
 * @date 2019/12/16 16:34
 */
@Component
@RabbitListener(queues = "FIRST_QUEUE")
public class FirstConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println(" first queue received msg : " + msg);
    }

}
