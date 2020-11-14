package ru.javatrainee.study.advanced.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javatrainee.study.advanced.entity.dto.PersonDTO;
import ru.javatrainee.study.advanced.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    void save(PersonDTO personDTO);

    Person findByName(String name);

    Person findById(long id);

    void deleteById(long id);

    void deleteByName(String name);
}
