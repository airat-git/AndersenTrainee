package ru.javatrainee.study.advanced.service;

import ru.javatrainee.study.advanced.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findAllByPersonId(long id);
}
