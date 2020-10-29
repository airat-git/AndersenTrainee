package ru.javatrainee.study.patterns.structure.bridge;

import ru.javatrainee.study.patterns.structure.bridge.cars.Car;
import ru.javatrainee.study.patterns.structure.bridge.cars.Hatchback;
import ru.javatrainee.study.patterns.structure.bridge.cars.Sedan;
import ru.javatrainee.study.patterns.structure.bridge.cars.brands.Lada;
import ru.javatrainee.study.patterns.structure.bridge.cars.brands.Volvo;

public class Test {

    public static void main(String[] args) {

        Car car = new Sedan(new Lada());
        Car car1 = new Hatchback(new Volvo());
        car.showDetails();
        car1.showDetails();
    }
}
