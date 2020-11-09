package ru.javatrainee.study.multithreading;

import java.util.concurrent.Callable;

public class MyCallableThread extends Thread implements Callable {

    @Override
    public String call() {
        try {
            return Thread.currentThread().getName();
        }
        catch (Exception e){
            return "nothing to return";
        }
    }
}
