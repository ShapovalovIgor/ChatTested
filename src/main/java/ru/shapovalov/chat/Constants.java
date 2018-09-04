package ru.shapovalov.chat;

import javax.jms.Session;

public class Constants {
    public static final String userQueueName = "client.users";;
    public static final String messageQueueName = "client.messages";
    public static final String messageBrokerUrl = "vm://localhost";

}
