package ru.javatrainee.study.patterns.structure.bridge.cars.brands;

import ru.javatrainee.study.patterns.structure.bridge.Make;

public class Lada implements Make {

    @Override
    public void showMake() {
        System.out.println("Lada");
    }
}
