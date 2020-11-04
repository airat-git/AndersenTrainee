package ru.javatrainee.study.patterns.generative.abstractfactory.win;

import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Mouse;

public class WinMouse implements Mouse {
    public void click() {
        System.out.println("This is Windows mouse");
    }
}
