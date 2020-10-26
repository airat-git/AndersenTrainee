package ru.javatrainee.study.patterns.structure.bridge.cars.brands;

import ru.javatrainee.study.patterns.structure.bridge.Make;

public class Volvo implements Make {

    @Override
    public void showMake() {
        System.out.println("Volvo");
    }
}
