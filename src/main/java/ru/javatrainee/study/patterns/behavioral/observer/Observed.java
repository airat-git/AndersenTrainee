package ru.javatrainee.study.patterns.behavioral.observer;

public interface Observed {

    void addObserver(Observer observer);

    void notifyObservers();

    void setChanges(int temp,int press);
}
