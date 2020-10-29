package ru.javatrainee.study.patterns.behavioral.observer;

public class Test {

    public static void main(String[] args) {

        Observed meteoStation = new MeteoStation();
        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.setChanges(30,130);
        meteoStation.setChanges(45,140);
    }
}
