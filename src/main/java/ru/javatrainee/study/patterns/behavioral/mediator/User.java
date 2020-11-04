package ru.javatrainee.study.patterns.behavioral.mediator;

public abstract class User {

    public Chat chat;
    public String name;

    public User(Chat chat) {
        this.chat = chat;
    }
    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public void sendMessage(String message) {
        pingImitation();
        System.out.println(this + " отправил сообщение в чат: '" + message + "'");
        chat.sendMessage(message,this);

    }
    public void getMessage(String message) {
        pingImitation();
        System.out.println(this + " получил сообщение '" + message + "'");
    }

    public void pingImitation(){
        try {
            Thread.sleep((long) (Math.random() * 5000));
        }
        catch (InterruptedException ignored){}
    }

    @Override
    public String toString() {
        return name;
    }
}
