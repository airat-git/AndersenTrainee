package ru.javatrainee.study.advanced.dao;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javatrainee.study.advanced.exception.NoSuchDataInDBException;

import java.util.Objects;

@Slf4j
@Repository
public class AbstractDAO<T>{

    protected Session session;
    protected Transaction transaction;
    private final SessionFactory sessionFactory;

    @Autowired
    public AbstractDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T findById(long id, Class<T> tClass){
        T entity = openSession().get(tClass,id);
        if (Objects.isNull(entity)){
            throw new NoSuchDataInDBException();
        }
        return entity;
    }

    public void save(T entity){
        openSession().save(entity);
        transaction.commit();
        closeSession();
    }

    public void update(T entity){
        openSession().merge(entity);
        transaction.commit();
        closeSession();
    }

    public void delete(T entity){
        openSession().delete(entity);
        transaction.commit();
        closeSession();
    }

    protected final Session openSession(){
        session = sessionFactory.openSession();
        openTransaction();
        return session;
    }

    protected final void openTransaction(){
        transaction = session.beginTransaction();
    }

    protected final void closeSession(){
        session.close();
    }
}
