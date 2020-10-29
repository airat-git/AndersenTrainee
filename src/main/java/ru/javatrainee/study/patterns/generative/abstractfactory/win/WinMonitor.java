package ru.javatrainee.study.patterns.generative.abstractfactory.win;

import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Monitor;

public class WinMonitor implements Monitor {
    public void show() {
        System.out.println("This is Windows monitor");
    }
}
