package ru.javatrainee.study.chat.messages;

import lombok.Getter;

@Getter
public class SystemMessage extends Message {

    public SystemMessage(String text) {
        super(text);
    }
}
