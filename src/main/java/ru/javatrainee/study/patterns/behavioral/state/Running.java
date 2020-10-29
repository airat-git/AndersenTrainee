package ru.javatrainee.study.patterns.behavioral.state;

public class Running implements Activity {

    @Override
    public void doIt(Human human) {
        System.out.println("Бегаю");
        human.setActivity(new PlayingHockey());
    }
}
