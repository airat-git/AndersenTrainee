package ru.javatrainee.study.chat.starters;


import ru.javatrainee.study.chat.client.Client;

public class ClientStarter {
    public static void main(String[] args) {
        Client client = new Client("Ayrat");
        client.start();
    }
}
