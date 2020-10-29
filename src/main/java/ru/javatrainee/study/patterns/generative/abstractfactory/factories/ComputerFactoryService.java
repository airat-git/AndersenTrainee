package ru.javatrainee.study.patterns.generative.abstractfactory.factories;

import ru.javatrainee.study.patterns.generative.abstractfactory.mac.MacComputerFactory;
import ru.javatrainee.study.patterns.generative.abstractfactory.win.WinComputerFactory;

public class ComputerFactoryService {

    public static ComputerFactory getComputerFactory(String userChoice){

        if (userChoice.equals("Mac")){
            return new MacComputerFactory();
        }
        if (userChoice.equals("Win")){
            return new WinComputerFactory();
        }
        throw new NullPointerException();
    }
}
