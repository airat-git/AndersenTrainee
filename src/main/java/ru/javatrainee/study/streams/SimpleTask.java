package ru.javatrainee.study.streams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleTask extends Task {

    private static final String INCREMENT_MESSAGE = "Четное после увелечения на 1: ";

    public static void main(String[] args) {

        collection.stream()
                .filter(n -> n % 2 == 0)
                .peek(n -> log.debug("Четное число: " + n))
                .map(n -> n = n + 1)
                .forEach(n -> log.info(INCREMENT_MESSAGE + n));

        log.info("Parallel Stream with forEach()");
        collection.parallelStream()
                .map(n -> n = n + 1)
                .forEach(n -> log.info(INCREMENT_MESSAGE + n));

        log.info("Parallel Stream with forEachOrder()");
        collection.parallelStream()
                .map(n -> n = n + 1)
                .forEachOrdered(n -> log.info(INCREMENT_MESSAGE + n));
    }
}
