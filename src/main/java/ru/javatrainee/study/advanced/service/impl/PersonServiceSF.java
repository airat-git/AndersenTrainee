package ru.javatrainee.study.advanced.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javatrainee.study.advanced.exception.FindException;
import ru.javatrainee.study.advanced.exception.NoSuchDataInDBException;
import ru.javatrainee.study.advanced.dao.PersonDAO;
import ru.javatrainee.study.advanced.entity.dto.PersonDTO;
import ru.javatrainee.study.advanced.entity.Car;
import ru.javatrainee.study.advanced.entity.Person;
import ru.javatrainee.study.advanced.service.PersonService;

import java.util.Objects;

@Slf4j
@Service
public class PersonServiceSF implements PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceSF(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void save(PersonDTO personDTO){
        Person person = new Person(personDTO.getName(), personDTO.getNumber());
        Car car = personDTO.getCar();
        if (Objects.nonNull(personDTO.getCar())){
            car.setPerson(person);
            person.getCars().add(car);
        }
        personDAO.save(person);
    }

    public Person findByName(String name){
        try {
            Person person = personDAO.findByName(name);
            log.info("Person with name {} found: {}",name,person);
            return person;
        }
        catch (NoSuchDataInDBException e){
            log.error("Person with name {} not found",name);
            throw new FindException();
        }
    }

    public Person findById(long id) {
        try {
            Person person = personDAO.findById(id,Person.class);
            log.info("Person with id {} found: {}",id,person);
            return person;
        } catch (NoSuchDataInDBException e) {
            log.error("Person with id {} not found",id);
            throw new FindException();
        }
    }

    @Override
    public void update(Person person) {
        personDAO.update(person);
    }

    public void update(PersonDTO personDTO){
        try {
            Person person = findByName(personDTO.getName());
            person.setName(personDTO.getName());
            person.setNumber(personDTO.getNumber());
            Car car = personDTO.getCar();
            if (Objects.nonNull(car)){
                car.setPerson(person);
                person.getCars().add(car);
            }
            personDAO.update(person);
            log.info("Person with id {} updated: {}",person.getId(),person);
        }
        catch (FindException e){
            log.info("Person with name {} not updated",personDTO.getName());
        }
    }

    public void deleteById(long id){
        try {
            personDAO.delete(findById(id));
            log.info("Person with id {} deleted",id);
        } catch (FindException e) {
            log.error("Person with id {} not deleted",id);
        }
    }

    public void deleteByName(String name){
        try {
            personDAO.delete(findByName(name));
            log.info("Person with name {} deleted",name);
        } catch (FindException e) {
            log.error("Person with name {} not deleted",name);
        }
    }
}
