package ru.javatrainee.study.advanced.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.javatrainee.study.advanced.entity.Car;

@Data
@AllArgsConstructor
public class PersonDTO {

    private String name;
    private int number;
    private Car car;
}
