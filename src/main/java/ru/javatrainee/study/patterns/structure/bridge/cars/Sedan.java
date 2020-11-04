package ru.javatrainee.study.patterns.structure.bridge.cars;

import ru.javatrainee.study.patterns.structure.bridge.Make;

public class Sedan extends Car{

    public Sedan(Make make) {
        super(make);
    }

    @Override
    public void showType() {
        System.out.println("Sedan");
    }
}
