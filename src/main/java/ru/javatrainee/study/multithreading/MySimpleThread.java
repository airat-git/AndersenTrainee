package ru.javatrainee.study.multithreading;

public class MySimpleThread extends Thread {

    @Override
    public synchronized void start() {
        super.start();
        setName("MySimpleThread");
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + getName());
    }
}
