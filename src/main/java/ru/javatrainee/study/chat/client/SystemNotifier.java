package ru.javatrainee.study.chat.client;

import ru.javatrainee.study.chat.messages.SystemMessage;

import java.io.*;

public class SystemNotifier extends MessageSender {

    public SystemNotifier() {
        super();
    }

    public void sendConnectMessage(String name) throws IOException {
        objectOutputStream.writeObject(new SystemMessage("В чат присоединился: " + name));
    }

    public void sendDisconnectedMessage(String name) throws IOException {
        objectOutputStream.writeObject(new SystemMessage(name + " покинул чат"));

    }
}
