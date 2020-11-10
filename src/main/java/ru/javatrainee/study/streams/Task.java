package ru.javatrainee.study.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Task {

    protected static List<Integer> collection;

    static {
        collection = Stream.iterate(1, n -> n = n + 1)
                .limit(5)
                .collect(Collectors.toList());
    }
}
