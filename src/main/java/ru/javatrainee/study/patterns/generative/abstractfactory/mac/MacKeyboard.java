package ru.javatrainee.study.patterns.generative.abstractfactory.mac;

import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Keyboard;

public class MacKeyboard implements Keyboard {

    public void button() {
        System.out.println("This is Mac keyboard");
    }
}
