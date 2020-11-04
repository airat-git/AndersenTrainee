package ru.javatrainee.study.patterns.behavioral.command;

public abstract class CommandAbstract implements Command {

    public Computer computer;

    public CommandAbstract(Computer computer) {
        this.computer = computer;
    }
}
