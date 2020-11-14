package ru.javatrainee.study.advanced.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.javatrainee.study.advanced.entity.Car;
import ru.javatrainee.study.advanced.entity.Person;

@Component
public class HibernateConfig {

    @Bean("sessionFactory")
    public SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Car.class);
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
