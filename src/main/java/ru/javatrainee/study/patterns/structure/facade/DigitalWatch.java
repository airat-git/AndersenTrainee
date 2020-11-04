package ru.javatrainee.study.patterns.structure.facade;

public class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("Время на электронных часах");
    }
}
