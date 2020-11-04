package ru.javatrainee.study.patterns.structure.bridge.cars;

import lombok.AllArgsConstructor;
import ru.javatrainee.study.patterns.structure.bridge.Make;

@AllArgsConstructor
public abstract class Car {

    private Make make;

    public void showDetails(){
        showType();
        make.showMake();
    }

    public abstract void showType();
}
