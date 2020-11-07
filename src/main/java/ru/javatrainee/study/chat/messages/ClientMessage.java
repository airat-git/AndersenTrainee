package ru.javatrainee.study.chat.messages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.javatrainee.study.chat.client.Client;

@Getter
@NoArgsConstructor
public class ClientMessage extends Message {

    public ClientMessage(Client client, String text) {
        super(text);
        this.client = client;
    }
}
