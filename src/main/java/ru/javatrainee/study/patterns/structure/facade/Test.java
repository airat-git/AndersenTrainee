package ru.javatrainee.study.patterns.structure.facade;

public class Test {
    public static void main(String[] args) {

        WatchFactory watchFactory = new DigitalWatchFactory();
        Watch watch = watchFactory.createWatch();
        watch.showTime();
    }
}
