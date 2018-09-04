package ru.shapovalov.chat.servlets;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shapovalov.chat.Constants;
import ru.shapovalov.chat.dao.User;
import javax.jms.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Producer {

    public void produceMessage(String messages, ActiveMQConnectionFactory cf) {
        Connection connectionFactory;
        Session session;
        try {
            connectionFactory = cf.createConnection();
            connectionFactory.start();
            session = connectionFactory.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(Constants.messageQueueName);
            MessageProducer messageProducer = session.createProducer(destination);
            messageProducer.send(session.createTextMessage(messages));
            connectionFactory.stop();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void produceUsers(User user, ActiveMQConnectionFactory cf) {
        produce(user, Constants.userQueueName, cf);
    }

    private void produce(Object object, String queueName, ActiveMQConnectionFactory cf) {
        Connection connectionFactory;
        Session session;
        try {
            connectionFactory = cf.createConnection();
            session = connectionFactory.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);
            MessageProducer messageProducer = session.createProducer(destination);
            messageProducer.send(session.createObjectMessage((Serializable) object));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
