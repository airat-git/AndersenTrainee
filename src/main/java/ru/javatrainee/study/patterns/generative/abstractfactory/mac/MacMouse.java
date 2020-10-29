package ru.javatrainee.study.patterns.generative.abstractfactory.mac;

import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Mouse;

public class MacMouse implements Mouse {

    public void click() {
        System.out.println("This is Mac mouse");
    }
}
