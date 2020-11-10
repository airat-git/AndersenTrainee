package ru.javatrainee.study.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdvancedTask extends Task{

    public static void main(String[] args) {

        Stream<Integer> stream = collection.stream();
        IntStream.range(6,11).forEach(collection::add);
        stream.forEach(System.out::println);
    }
}
