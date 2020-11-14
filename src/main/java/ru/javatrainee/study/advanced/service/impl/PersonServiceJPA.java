package ru.javatrainee.study.advanced.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javatrainee.study.advanced.entity.dto.PersonDTO;
import ru.javatrainee.study.advanced.entity.Car;
import ru.javatrainee.study.advanced.entity.Person;
import ru.javatrainee.study.advanced.exception.FindException;
import ru.javatrainee.study.advanced.repository.PersonRepository;
import ru.javatrainee.study.advanced.service.PersonService;

import java.util.Objects;

@Slf4j
@Service
public class PersonServiceJPA implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceJPA(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findByName(String name) {
        Person person = personRepository.findByName(name);
        if (Objects.nonNull(person)){
            log.info("Find person with id {}: {}",person.getId(),person);
            return person;
        }
        log.error("Person with name {} not found",name);
        throw new FindException();
    }

    @Override
    public Person findById(long id){
        Person person = personRepository.findById(id);
        if (Objects.nonNull(person)){
            log.info("Find person with id {}: {}",person.getId(),person);
            return person;
        }
        log.error("Person with id {} not found",id);
        throw new FindException();
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
        log.info("Person with id {} updated: {}",person.getId(),person);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        try {
            Person person = findById(id);
            personRepository.delete(person);
            log.info("Person with id {} deleted",id);
        }
        catch (FindException e){
            log.error("Person with id {} not deleted",id);
        }
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        try {
            Person person = findByName(name);
            personRepository.delete(person);
            log.info("Person with name {} deleted",name);
        }
        catch (FindException e){
            log.error("Person with name {} not deleted",name);
        }
    }

    @Override
    @Transactional
    public void save(PersonDTO personDTO) {
        Person person;
        Car car = personDTO.getCar();
        try {
            person = findByName(personDTO.getName());
            person.setName(personDTO.getName());
            person.setNumber(personDTO.getNumber());
            car.setPerson(person);
            person.getCars().add(car);
            update(person);
        }
        catch (FindException e){
            person = new Person(personDTO.getName(),personDTO.getNumber());
            car.setPerson(person);
            person.getCars().add(car);
            personRepository.save(person);
            log.info("Person with id {} saved: {}",person.getId(),person);
        }
    }
}
