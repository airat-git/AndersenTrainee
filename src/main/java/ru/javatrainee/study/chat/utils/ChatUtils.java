package ru.javatrainee.study.chat.utils;

import lombok.extern.slf4j.Slf4j;
import ru.javatrainee.study.chat.exceptions.ServerConnectException;
import ru.javatrainee.study.chat.messages.Message;
import ru.javatrainee.study.chat.messages.SystemMessage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Slf4j
public class ChatUtils {

    private ChatUtils(){}

    public static void connectionCheck(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
        if (Objects.isNull(objectInputStream) || Objects.isNull(objectOutputStream)){
            try {
                throw new ConnectException();
            }
            catch (ConnectException e){
                log.error("Нет подключения для отправки/чтения сообщений");
                throw new ServerConnectException();
            }
        }
    }

    public static String messageConvert(Message message){
        Date date = message.getDate();
        String dateTime = new SimpleDateFormat().format(date);
        if (message instanceof SystemMessage){
            return dateTime + " "
                    + message.getText() + "";
        }
        return dateTime + " Сообщение от: " + message.getClient().getName() + ":'"
                + message.getText() + "'";
    }
}
