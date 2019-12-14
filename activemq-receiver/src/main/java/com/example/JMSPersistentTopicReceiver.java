package com.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zhangliang
 * @date 2019/12/10 13:22
 */
public class JMSPersistentTopicReceiver {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.182.128:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.setClientID("0000000");
            connection.start();

            Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            //创建目的地
            Topic destination = session.createTopic("myTopic");
            //创建发送者
            MessageConsumer consumer = session.createDurableSubscriber(destination,"0000000");

            TextMessage textMessage = (TextMessage) consumer.receive();

            System.out.println(textMessage.getText());
            session.commit();
            session.close();
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
