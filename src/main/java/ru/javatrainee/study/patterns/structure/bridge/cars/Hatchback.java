package ru.javatrainee.study.patterns.structure.bridge.cars;

import ru.javatrainee.study.patterns.structure.bridge.Make;

public class Hatchback extends Car{

    public Hatchback(Make make) {
        super(make);
    }

    @Override
    public void showType() {
        System.out.println("Hatchback");
    }
}
