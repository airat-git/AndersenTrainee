package ru.javatrainee.study.chat.messages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.javatrainee.study.chat.client.Client;

import java.io.Serializable;
import java.util.Date;

@Getter
@NoArgsConstructor
public class Message implements Serializable {

    protected Client client;
    protected String text;
    protected Date date;

    public Message(String text) {
        this.text = text;
        this.date = new Date();
    }
}
