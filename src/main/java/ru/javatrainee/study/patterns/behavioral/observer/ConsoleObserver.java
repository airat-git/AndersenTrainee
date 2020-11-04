package ru.javatrainee.study.patterns.behavioral.observer;

public class ConsoleObserver implements Observer {

    @Override
    public void showChanges(int temp, int press) {
        System.out.printf("Изменение температуры '%d' и давления '%d'",temp,press);
        System.out.println();
    }
}
