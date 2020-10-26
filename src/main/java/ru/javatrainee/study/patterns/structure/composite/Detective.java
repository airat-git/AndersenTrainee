package ru.javatrainee.study.patterns.structure.composite;

public class Detective implements Book{

    @Override
    public void read() {
        System.out.println("Я книга дектив");
    }
}
