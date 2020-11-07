package ru.javatrainee.study.chat.server;

import lombok.extern.slf4j.Slf4j;
import ru.javatrainee.study.chat.messages.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

@Slf4j
public class Server {

    private static final int PORT = 3443;
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    public Server() {
        Socket clientSocket;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен");
            while (true) {
                clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);
                new Thread(client).start();
            }
        }
        catch (IOException e) {
            log.error("Сервер был остановлен",e);
        }
    }

    public void sendMessageToAllClients(Message message) {
        for (ClientHandler o : clients) {
            o.sendMessage(message);
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}
