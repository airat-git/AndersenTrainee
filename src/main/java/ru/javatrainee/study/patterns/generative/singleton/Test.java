package ru.javatrainee.study.patterns.generative.singleton;


public class Test {

    public static void main(String[] args) {

        SimpleSingleton first = SimpleSingleton.getInstance();
        SimpleSingleton second = SimpleSingleton.getInstance();
        SimpleSingleton third = SimpleSingleton.getInstance();
        System.out.println(first.equals(second));
        System.out.println(second.equals(third));
    }
}
