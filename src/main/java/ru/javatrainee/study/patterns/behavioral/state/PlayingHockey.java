package ru.javatrainee.study.patterns.behavioral.state;

public class PlayingHockey implements Activity{

    @Override
    public void doIt(Human human) {
        System.out.println("Играю в хоккей");
    }
}
