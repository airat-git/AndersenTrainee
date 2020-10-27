package ru.javatrainee.study.patterns.behavioral.command;

public class StopCommand extends CommandAbstract {

    public StopCommand(Computer computer) {
        super(computer);
    }

    @Override
    public void execute() {
        computer.stop();
    }
}
