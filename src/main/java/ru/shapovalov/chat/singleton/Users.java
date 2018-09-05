package ru.shapovalov.chat.singleton;

import ru.shapovalov.chat.dao.User;

import java.util.ArrayList;
import java.util.List;

public class Users {
    public List<User> userList;
    private Users(){
        userList = new ArrayList<>();
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
