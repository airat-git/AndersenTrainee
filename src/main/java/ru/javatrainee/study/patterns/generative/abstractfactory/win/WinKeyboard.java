package ru.javatrainee.study.patterns.generative.abstractfactory.win;

import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Keyboard;

public class WinKeyboard implements Keyboard {
    public void button() {
        System.out.println("This is Windows keyboard");
    }
}
