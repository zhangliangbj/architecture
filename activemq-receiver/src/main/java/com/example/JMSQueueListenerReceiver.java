package com.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zhangliang
 * @date 2019/12/10 13:22
 */
public class JMSQueueListenerReceiver {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.182.128:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            //创建目的地
            Destination destination = session.createQueue("myQueue");
            //创建发送者
            MessageConsumer consumer = session.createConsumer(destination);

            MessageListener messageListener = new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println(((TextMessage)message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            };

            while (true){
                consumer.setMessageListener(messageListener);
                session.commit();
                session.close();
            }

//            TextMessage textMessage = (TextMessage) consumer.receive();
//
//            System.out.println(textMessage.getText());
//            session.commit();
//            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
