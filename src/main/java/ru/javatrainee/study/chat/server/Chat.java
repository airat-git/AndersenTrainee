package ru.javatrainee.study.chat.server;

import ru.javatrainee.study.chat.messages.SystemMessage;
import ru.javatrainee.study.chat.messages.Message;
import ru.javatrainee.study.chat.server.bot.Bot;
import ru.javatrainee.study.chat.server.bot.SimpleBot;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Chat {

    private Socket socket;
    private static final String HOST = "localhost";
    private static final int PORT = 3443;
    private Bot bot;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public Chat() {
        try {
            socket = new Socket(HOST,PORT);
            bot = new SimpleBot();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.println("Добро пожаловать в чат. Здесь будут отображаться ваши сообщения");
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                Message message = (Message) objectInputStream.readObject();
                String botMessage = botCheck(message.getText());
                System.out.println(messageConvert(message));
                if (Objects.nonNull(botMessage)){
                    Thread.sleep(2000);
                    System.out.println(botMessage);
                }
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private String messageConvert(Message message){
        Date date = message.getDate();
        String dateTime = new SimpleDateFormat().format(date);
        if (message instanceof SystemMessage){
            return dateTime + " "
                    + message.getText() + "";
        }
        return dateTime + " Сообщение от: " + message.getClient().getName() + ":'"
                + message.getText() + "'";
    }

    private String botCheck(String message){
        String response = bot.checkWord(message);
        return Objects.isNull(response) ? null : response;
    }
}
