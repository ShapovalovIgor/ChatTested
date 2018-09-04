package ru.shapovalov.chat.singleton;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.List;

public class Users {
    public static List<Users> userList;
    private Users(){
        userList = new ArrayQueue<>(30);
    }
    private static volatile Users instance;

    public static Users getInstance() {
        Users localInstance = instance;
        if (localInstance == null) {
            synchronized (Users.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Users();
                }
            }
        }
        return localInstance;
    }
}
