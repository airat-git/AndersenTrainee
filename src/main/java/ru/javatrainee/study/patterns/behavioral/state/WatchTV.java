package ru.javatrainee.study.patterns.behavioral.state;

public class WatchTV implements Activity {

    @Override
    public void doIt(Human human) {
        System.out.println("Смотрю телек");
        human.setActivity(new Running());
    }
}
