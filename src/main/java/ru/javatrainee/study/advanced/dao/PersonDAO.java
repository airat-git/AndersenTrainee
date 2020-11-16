package ru.javatrainee.study.advanced.dao;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.javatrainee.study.advanced.entity.Person;
import ru.javatrainee.study.advanced.exception.NoSuchDataInDBException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Repository
public class PersonDAO extends AbstractDAO<Person> {

    public PersonDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Person findByName(String name){
        List<Person> resultList = openSession()
                .createQuery("FROM Person where name = :name")
                .setParameter("name",name)
                .list();
        Optional<Person> person = resultList.stream()
                .filter(p -> Objects.nonNull(p.getName()) && p.getName().equals(name)).findAny();
        closeSession();
        if (person.isEmpty()){
            throw new NoSuchDataInDBException();
        }
        return person.get();
    }
}
