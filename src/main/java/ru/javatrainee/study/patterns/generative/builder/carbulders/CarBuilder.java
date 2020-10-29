package ru.javatrainee.study.patterns.generative.builder.carbulders;

import lombok.Getter;
import ru.javatrainee.study.patterns.generative.builder.Car;

@Getter
public abstract class CarBuilder {

    protected Car car;

    public CarBuilder start(){
        car = new Car();
        return this;
    }

    protected abstract CarBuilder setName();

    protected abstract CarBuilder setMaxSpeed();

    protected abstract CarBuilder setTransmission();
}
