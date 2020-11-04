package ru.javatrainee.study.patterns.behavioral.mediator;

public class Admin extends User {

    public Admin(Chat chat) {
        super(chat);
    }

    @Override
    public void getMessage(String message) {
        pingImitation();
        System.out.println("Администратор получил сообщение '" + message + "'");
    }
}
