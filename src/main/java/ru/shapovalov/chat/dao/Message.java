package ru.shapovalov.chat.dao;

public class Message extends User {
    public Message(String name, String color) {
        super(name, color);
    }

    public Message(String name, String color, String message) {
        super(name, color);
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
