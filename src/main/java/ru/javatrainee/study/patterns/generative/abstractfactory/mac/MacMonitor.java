package ru.javatrainee.study.patterns.generative.abstractfactory.mac;

import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Monitor;

public class MacMonitor implements Monitor {

    public void show() {
        System.out.println("This is Mac monitor");
    }
}
