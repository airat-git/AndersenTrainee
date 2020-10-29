package ru.javatrainee.study.patterns.generative.abstractfactory.mac;

import ru.javatrainee.study.patterns.generative.abstractfactory.factories.ComputerFactory;
import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Keyboard;
import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Monitor;
import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Mouse;

public class MacComputerFactory implements ComputerFactory {

    public Mouse createMouse() {
        return new MacMouse();
    }

    public Keyboard crateKeyboard() {
        return new MacKeyboard();
    }

    public Monitor createMonitor() {
        return new MacMonitor();
    }
}
