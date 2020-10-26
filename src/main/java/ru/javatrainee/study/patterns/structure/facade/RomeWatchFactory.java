package ru.javatrainee.study.patterns.structure.facade;

public class RomeWatchFactory implements WatchFactory{

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
