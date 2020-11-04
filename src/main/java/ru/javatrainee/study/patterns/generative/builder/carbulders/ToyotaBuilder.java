package ru.javatrainee.study.patterns.generative.builder.carbulders;

import ru.javatrainee.study.patterns.generative.builder.Transmission;

public class ToyotaBuilder extends CarBuilder {

    @Override
    protected CarBuilder setName() {
        car.setName("Toyota");
        return this;
    }

    @Override
    protected CarBuilder setMaxSpeed() {
        car.setMaxSpeed(250);
        return this;
    }

    @Override
    protected CarBuilder setTransmission() {
        car.setTransmission(Transmission.AUTO);
        return this;
    }
}
