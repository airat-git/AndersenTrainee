package ru.javatrainee.study.chat.client;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.javatrainee.study.chat.messages.ClientMessage;

import java.io.*;

@Slf4j
@NoArgsConstructor
public class Client extends MessageSender {

    public Client(String name) {
        super();
        this.name = name;
    }

    public void start(){
        SystemNotifier systemNotifier = new SystemNotifier();
        try {
            systemNotifier.sendConnectMessage(name);
            while (true){
                System.out.print(name + ", напишите сюда ваше сообщение: ");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                message = bufferedReader.readLine();
                if (message.equalsIgnoreCase("***")) {
                    systemNotifier.sendDisconnectedMessage(name);
                    break;
                }
                objectOutputStream.writeObject(new ClientMessage(this,message));
            }
        } catch (IOException e) {
            log.error("Ошибка подключения к серверу. Возможно он был остановлен. Попробуйте переподключиться позже",e);
        }
    }
}
