package ru.javatrainee.study.chat.client;

import ru.javatrainee.study.chat.messages.SystemMessage;

import java.io.*;

public class SystemNotifier extends MessageSender {

    public SystemNotifier() {
        super();
    }

    public void sendConnectMessage(String name){
        try {
            objectOutputStream.writeObject(new SystemMessage("В чат присоединился: " + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendDisconnectedMessage(String name){
        try {
            objectOutputStream.writeObject(new SystemMessage(name + " покинул чат"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
