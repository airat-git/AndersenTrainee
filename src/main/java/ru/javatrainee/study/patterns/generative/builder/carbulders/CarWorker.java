package ru.javatrainee.study.patterns.generative.builder.carbulders;

import ru.javatrainee.study.patterns.generative.builder.Car;

public class CarWorker {

    public Car build(CarBuilder carBuilder){
        return carBuilder.
                start().
                setName().
                setMaxSpeed().
                setTransmission().getCar();
    }
}
