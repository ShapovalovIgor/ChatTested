package ru.shapovalov.chat.singleton;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.List;

public class Messages {
    public static List<String> messageList;
    private Messages(){
        messageList = new ArrayQueue<>(30);
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
