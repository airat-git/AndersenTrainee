package ru.javatrainee.study.patterns.generative.abstractfactory.factories;

import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Keyboard;
import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Monitor;
import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Mouse;

public interface ComputerFactory {

    Mouse createMouse();

    Keyboard crateKeyboard();

    Monitor createMonitor();
}
