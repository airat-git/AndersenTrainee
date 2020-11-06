package ru.javatrainee.study.chat.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.javatrainee.study.chat.messages.ClientMessage;

import java.io.*;

@Getter
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
            e.printStackTrace();
        }
        finally {
            try {
                objectOutputStream.close();
                objectInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
