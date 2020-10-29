package ru.javatrainee.study.patterns.generative.builder;

import ru.javatrainee.study.patterns.generative.builder.carbulders.CarWorker;
import ru.javatrainee.study.patterns.generative.builder.carbulders.OpelBuilder;
import ru.javatrainee.study.patterns.generative.builder.carbulders.ToyotaBuilder;

public class Test {

    public static void main(String[] args) {

        Car toyota = new CarWorker().build(new ToyotaBuilder());
        toyota.getCharacters();
        Car opel = new CarWorker().build(new OpelBuilder());
        opel.getCharacters();
    }
}
