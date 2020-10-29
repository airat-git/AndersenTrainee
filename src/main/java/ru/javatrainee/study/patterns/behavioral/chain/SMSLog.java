package ru.javatrainee.study.patterns.behavioral.chain;

public class SMSLog extends Logger {

    public SMSLog(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("CMC: " + message);
    }
}
