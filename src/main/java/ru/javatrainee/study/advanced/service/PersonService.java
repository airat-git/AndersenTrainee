package ru.javatrainee.study.advanced.service;

import ru.javatrainee.study.advanced.entity.dto.PersonDTO;
import ru.javatrainee.study.advanced.entity.Person;

public interface PersonService {

    Person findByName(String name);

    Person findById(long id);

    void update(Person person);

    void deleteByName(String name);

    void save(PersonDTO personDTO);

    void deleteById(long id);
}