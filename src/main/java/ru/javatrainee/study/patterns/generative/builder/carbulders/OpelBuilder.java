package ru.javatrainee.study.patterns.generative.builder.carbulders;

import ru.javatrainee.study.patterns.generative.builder.Transmission;

public class OpelBuilder extends CarBuilder{

    @Override
    public CarBuilder setName() {
        car.setName("Opel");
        return this;
    }

    @Override
    protected CarBuilder setMaxSpeed() {
        car.setMaxSpeed(120);
        return this;
    }

    @Override
    protected CarBuilder setTransmission() {
        car.setTransmission(Transmission.MANUAL);
        return this;
    }
}
