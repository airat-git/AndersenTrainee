package ru.javatrainee.study.multithreading;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        new MySimpleThread().start();

        new Thread(()-> System.out.println("Thread name: " +
                Thread.currentThread().getName()),"MyRunnableThread").start();
        Callable myCallableThread = new Callable() {
            @Override
            public Object call() throws Exception {
                return Thread.currentThread().getName();
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(myCallableThread);
        new Thread(futureTask,"Thread name: MyCallableThread").start();
        System.out.println(futureTask.get());
    }
}
