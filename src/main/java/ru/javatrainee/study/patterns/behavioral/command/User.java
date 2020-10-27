package ru.javatrainee.study.patterns.behavioral.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    private Command start;
    private Command stop;
    private Command reset;

    public void startComputer(){
        start.execute();
    }
    public void stopComputer(){
        stop.execute();
    }
    public void resetComputer (){
        reset.execute();
    }
}
