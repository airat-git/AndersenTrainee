package ru.javatrainee.study.patterns.behavioral.strategy;

public class Test {

    public static void main(String[] args) {

        StrategyClient strategyClient = new StrategyClient();
        strategyClient.setStrategy(new BubbleSort());
        strategyClient.executeStrategy(new int[]{45,44,43,3,2,1,0});
        strategyClient.setStrategy(new SelectSort());
        strategyClient.executeStrategy(new int[]{45,44,43,3,2,1,0});
    }
}
