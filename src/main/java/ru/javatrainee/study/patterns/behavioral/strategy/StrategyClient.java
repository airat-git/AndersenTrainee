package ru.javatrainee.study.patterns.behavioral.strategy;

public class StrategyClient {

    private Sortable sortable;

    public void setStrategy(Sortable sortable) {
        this.sortable = sortable;
    }

    public void executeStrategy(int[] arr){
        sortable.sort(arr);
    }
}
