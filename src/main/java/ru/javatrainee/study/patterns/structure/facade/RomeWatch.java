package ru.javatrainee.study.patterns.structure.facade;

public class RomeWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println("Время на римских часах ");
    }
}
