package ru.javatrainee.study.patterns.behavioral.mediator;

public class Test {

    public static void main(String[] args) {

        TextChat textChat = new TextChat();
        User admin = new Admin(textChat);
        User user = new SimpleUser(textChat,"Вова");
        User user1 = new SimpleUser(textChat, "Миша");
        User user2 =  new SimpleUser(textChat,"Болик");
        textChat.addUser(user2);
        textChat.setAdmin(admin);
        textChat.addUser(user);
        textChat.addUser(user1);
        user.sendMessage("hi");
        user2.sendMessage("Ну привет))");
    }
}
