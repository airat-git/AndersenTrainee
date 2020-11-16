package ru.javatrainee.study.advanced;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        MyImmutableClass myImmutableClass = new MyImmutableClass(150);
        MyImmutableClass myImmutableClass1  = myImmutableClass.setValue(200);
        log.info("myImmutableClass equals myImmutableClass1 : '{}'",myImmutableClass.equals(myImmutableClass1));
        log.info("myImmutableClass value: '{}'",myImmutableClass.getValue());
        log.info("myImmutableClass1 value: '{}'",myImmutableClass1.getValue());
    }
}
