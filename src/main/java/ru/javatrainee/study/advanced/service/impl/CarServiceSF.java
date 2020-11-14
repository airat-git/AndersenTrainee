package ru.javatrainee.study.advanced.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javatrainee.study.advanced.entity.Car;
import ru.javatrainee.study.advanced.dao.CarDAO;
import ru.javatrainee.study.advanced.service.CarService;

import java.util.List;

@Service
public class CarServiceSF implements CarService {

    private final CarDAO carDAO;

    @Autowired
    public CarServiceSF(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> findAllByPersonId(long id) {
        return carDAO.findAllByPersonId(id);
    }
}
