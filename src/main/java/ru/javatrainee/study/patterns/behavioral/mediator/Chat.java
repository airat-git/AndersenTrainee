package ru.javatrainee.study.patterns.behavioral.mediator;

import java.util.HashSet;

public class Chat {

    private HashSet<User> usersInChat = new HashSet<>();
    private User admin;

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUser(User user){
        usersInChat.add(user);
        System.out.println(user + " добавлен в чат");
    }

    protected void sendMessage(String message, User user) {
        for (User u : usersInChat){
            if (!u.equals(user)) {
                u.getMessage(message);
            }
        }
        admin.getMessage(message);
    }
}
