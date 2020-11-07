package ru.javatrainee.study.chat.client;

import lombok.extern.slf4j.Slf4j;
import ru.javatrainee.study.chat.utils.ChatUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

@Slf4j
public abstract class MessageSender implements Serializable {

    protected String name;
    protected transient Socket socket;
    protected static final String HOST = "localhost";
    protected static final int PORT = 3443;
    protected transient String message;
    protected transient ObjectOutputStream objectOutputStream;
    protected transient ObjectInputStream objectInputStream;

    public MessageSender() {
        try {
            socket = new Socket(HOST,PORT);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            log.error("Не удается подключиться к серверу: HOST {}, PORT {}",HOST,PORT);
            ChatUtils.connectionCheck(objectOutputStream,objectInputStream);
        }
    }

    public String getName(){
        return name;
    }
}
