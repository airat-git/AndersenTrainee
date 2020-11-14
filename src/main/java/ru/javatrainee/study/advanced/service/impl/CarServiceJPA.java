package ru.javatrainee.study.advanced.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javatrainee.study.advanced.entity.Car;
import ru.javatrainee.study.advanced.exception.FindException;
import ru.javatrainee.study.advanced.repository.CarRepository;
import ru.javatrainee.study.advanced.service.CarService;

import java.util.List;

@Slf4j
@Service
public class CarServiceJPA implements CarService {

    private final CarRepository carRepository;
    private final PersonServiceJPA personServiceJPA;

    @Autowired
    public CarServiceJPA(CarRepository carRepository, PersonServiceJPA personServiceJPA) {
        this.carRepository = carRepository;
        this.personServiceJPA = personServiceJPA;
    }

    @Override
    public List<Car> findAllByPersonId(long id) {
        try {
            personServiceJPA.findById(id);
            List <Car> resultList = carRepository.findAllByPersonId(id);
            log.info("Cars found by person id {} : {}",id,resultList);
            return resultList;
        }
        catch (FindException e){
            log.error("Cars from person with id {} not found",id);
            throw new FindException();
        }
    }
}
