package ru.javatrainee.study.patterns.behavioral.chain;

public class EmailLog extends Logger{

    public EmailLog(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Емайл: " + message);
    }
}
