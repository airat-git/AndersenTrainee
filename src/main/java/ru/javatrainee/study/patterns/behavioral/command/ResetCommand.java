package ru.javatrainee.study.patterns.behavioral.command;

public class ResetCommand extends CommandAbstract {

    public ResetCommand(Computer computer) {
        super(computer);
    }

    @Override
    public void execute() {
        computer.reset();
    }
}
