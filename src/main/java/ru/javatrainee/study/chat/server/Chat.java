package ru.javatrainee.study.chat.server;

import lombok.extern.slf4j.Slf4j;
import ru.javatrainee.study.chat.messages.Message;
import ru.javatrainee.study.chat.server.bot.Bot;
import ru.javatrainee.study.chat.server.bot.SimpleBot;
import ru.javatrainee.study.chat.utils.ChatUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

@Slf4j
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
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            log.error("Не удается подключиться к серверу: HOST {}, PORT {}",HOST,PORT);
            ChatUtils.connectionCheck(objectOutputStream,objectInputStream);
        }
    }

    public void start(){
        System.out.println("Добро пожаловать в чат. Здесь будут отображаться ваши сообщения");
        try {
            while (true) {
                Message message = (Message) objectInputStream.readObject();
                String botMessage = botCheck(message.getText());
                System.out.println(ChatUtils.messageConvert(message));
                if (Objects.nonNull(botMessage)) {
                    Thread.sleep(2000);
                    System.out.println(botMessage);
                }
            }
        }
        catch (ClassNotFoundException e){
            log.error("Ошибка отображения сообщения",e);
        }
        catch (IOException | InterruptedException e) {
            log.error("Ошибка подключения к серверу. Возможно он был остановлен",e);
            Thread.currentThread().interrupt();
        }
    }

    private String botCheck(String message){
        String response = bot.checkWord(message);
        return Objects.isNull(response) ? null : response;
    }
}
