package ru.javatrainee.study.advanced.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.javatrainee.study.advanced.entity.Car;

import java.util.List;

@Repository
public class CarDAO extends AbstractDAO {

    public CarDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List <Car> findAllByPersonId(long id){
        List <Car> resultList = openSession().createQuery("FROM Car where personId = :id")
                .setParameter("id",id).list();
        closeSession();
        return resultList;
    }
}
