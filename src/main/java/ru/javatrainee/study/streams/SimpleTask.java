package ru.javatrainee.study.streams;

public class SimpleTask extends Task {

    private static final String INCREMENT_MESSAGE = "Четное после увелечения на 1: ";

    public static void main(String[] args) {

        collection.stream()
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("Четное число: " + n))
                .map(n -> n = n +1)
                .forEach(n -> System.out.println(INCREMENT_MESSAGE + n));

        System.out.println("Parallel Stream with forEach()");
        collection.parallelStream()
                .map(n -> n = n +1)
                .forEach(n -> System.out.println(INCREMENT_MESSAGE + n));

        System.out.println("Parallel Stream with forEachOrder()");
        collection.parallelStream()
                .map(n -> n = n +1)
                .forEachOrdered(n -> System.out.println(INCREMENT_MESSAGE + n));
    }
}
