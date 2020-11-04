package ru.javatrainee.study.patterns.behavioral.command;

public class StartCommand extends CommandAbstract{

    public StartCommand(Computer computer) {
        super(computer);
    }

    @Override
    public void execute() {
        computer.start();
    }
}
