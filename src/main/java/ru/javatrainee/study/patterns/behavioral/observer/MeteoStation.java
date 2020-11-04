package ru.javatrainee.study.patterns.behavioral.observer;

import java.util.ArrayList;

public class MeteoStation implements Observed {

    private int temp;
    private int press;
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers){
            observer.showChanges(temp,press);
        }
    }

    @Override
    public void setChanges(int temp, int press) {
        this.temp = temp;
        this.press = press;
        notifyObservers();
    }
}
