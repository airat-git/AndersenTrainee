package ru.javatrainee.study.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class AdvancedTask extends Task{

    public static void main(String[] args) {

        Stream<Integer> stream = collection.stream();
        IntStream.range(6,11).forEach(collection::add);
        stream.forEach(n -> log.info(String.valueOf(n)));
    }
}
