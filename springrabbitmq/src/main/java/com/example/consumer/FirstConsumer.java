package com.example.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author zhangliang
 * @date 2019/12/16 15:23
 */
public class FirstConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(FirstConsumer.class);
    @Override
    public void onMessage(Message message) {
        logger.info("The first consumer received message : " + message.getBody());
    }
}
