package ru.javatrainee.study.patterns.generative.abstractfactory.win;

import ru.javatrainee.study.patterns.generative.abstractfactory.factories.ComputerFactory;
import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Keyboard;
import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Monitor;
import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Mouse;

public class WinComputerFactory implements ComputerFactory {

    public Mouse createMouse() {
        return new WinMouse();
    }

    public Keyboard crateKeyboard() {
        return new WinKeyboard();
    }

    public Monitor createMonitor() {
        return new WinMonitor();
    }
}
