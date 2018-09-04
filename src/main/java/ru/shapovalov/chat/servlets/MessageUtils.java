package ru.shapovalov.chat.servlets;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageUtils {

    ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("vm://localhost?create=false");

//    public MessageUtils() {
//       cf.createConnection().
//    }
}
