package ru.javatrainee.study.advanced.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javatrainee.study.advanced.entity.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository <Car,Long> {

    List<Car> findAllByPersonId(long id);
}
