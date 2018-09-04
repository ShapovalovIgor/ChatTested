package ru.shapovalov.chat.dao;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String color;

    public User(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
