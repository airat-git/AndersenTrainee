package ru.javatrainee.study.multithreading;

public class MySimpleThread extends Thread {

    @Override
    public void start() {
        setName("MySimpleThread");
        super.start();
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }
}
