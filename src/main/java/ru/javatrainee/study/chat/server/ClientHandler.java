package ru.javatrainee.study.chat.server;

import lombok.extern.slf4j.Slf4j;
import ru.javatrainee.study.chat.messages.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

@Slf4j
public class ClientHandler implements Runnable {

    private Socket socket;
    private Server server;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                    Message message = (Message) objectInputStream.readObject();
                    server.sendMessageToAllClients(message);
                    Thread.sleep(100);
            }
        }
        catch (ClassNotFoundException e){
            e.getStackTrace();
        }
        catch (SocketException e){
            log.info("Участник покинул чат");
        }
        catch (InterruptedException | IOException e){
            log.warn("Неизвестная ошибка",e);
            Thread.currentThread().interrupt();
        }
         finally {
            this.close();
        }
    }

    public void sendMessage(Message message) {
        try {
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        server.removeClient(this);
    }
}

