package ru.shapovalov.chat.singleton;

import ru.shapovalov.chat.dao.Message;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Messages {
    public Queue<Message> messageList;
    private Messages(){
        messageList = new ConcurrentLinkedQueue<>();
    }
    private static volatile Messages instance;

    public static Messages getInstance() {
        Messages localInstance = instance;
        if (localInstance == null) {
            synchronized (Messages.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Messages();
                }
            }
        }
        return localInstance;
    }
}
