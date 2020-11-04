package ru.javatrainee.study.patterns.behavioral.chain;

public class FileLog extends Logger {

    public FileLog(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Файл: " + message);
    }
}
