package ru.javatrainee.study.patterns.generative.prototype;

public class Test {

    public static void main(String[] args) {

        Human original = new Human("a",1);
        Human copy = new CopyFactory().setPrototype(original).makeCopy();
        System.out.println(original);
        System.out.println(copy);
    }
}
