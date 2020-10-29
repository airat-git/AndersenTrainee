package ru.javatrainee.study.patterns.behavioral.state;

public class Relax implements Activity {

    @Override
    public void doIt(Human human) {
        System.out.println("Ничего не далаю пока");
        human.setActivity(new WatchTV());
    }
}
