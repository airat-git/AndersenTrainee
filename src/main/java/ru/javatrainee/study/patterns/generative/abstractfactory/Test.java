package ru.javatrainee.study.patterns.generative.abstractfactory;

import ru.javatrainee.study.patterns.generative.abstractfactory.factories.ComputerFactory;
import ru.javatrainee.study.patterns.generative.abstractfactory.factories.ComputerFactoryService;
import ru.javatrainee.study.patterns.generative.abstractfactory.parts.Mouse;

public class Test {

    public static void main(String[] args) {
        String userChoice = "Mac";
        ComputerFactory computerFactory = ComputerFactoryService.getComputerFactory(userChoice);
        Mouse mouse = computerFactory.createMouse();
        mouse.click();
    }
}
