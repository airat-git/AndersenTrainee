package ru.javatrainee.study.patterns.structure.facade;

public class DigitalWatchFactory implements WatchFactory{

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
