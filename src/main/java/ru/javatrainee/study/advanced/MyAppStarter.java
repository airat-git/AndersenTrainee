package ru.javatrainee.study.advanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.javatrainee.study.advanced.config.MyAppConfig;
import ru.javatrainee.study.advanced.service.CarService;
import ru.javatrainee.study.advanced.service.PersonService;
import ru.javatrainee.study.advanced.service.impl.CarServiceJPA;
import ru.javatrainee.study.advanced.service.impl.CarServiceSF;
import ru.javatrainee.study.advanced.service.impl.PersonServiceJPA;
import ru.javatrainee.study.advanced.service.impl.PersonServiceSF;

@Slf4j
public class MyAppStarter {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyAppConfig.class);

        PersonService personServiceJPA = ac.getBean(PersonServiceJPA.class);
        CarService carServiceJPA = ac.getBean(CarServiceJPA.class);

        PersonService personServiceSF = ac.getBean(PersonServiceSF.class);
        CarService carServiceSF = ac.getBean(CarServiceSF.class);
    }
}
