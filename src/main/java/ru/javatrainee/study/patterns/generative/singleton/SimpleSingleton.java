package ru.javatrainee.study.patterns.generative.singleton;

public class SimpleSingleton {

    private volatile static SimpleSingleton singleton;

    public static SimpleSingleton getInstance(){
        if (singleton==null){
            synchronized (SimpleSingleton.class){
                if (singleton == null){
                    singleton = new SimpleSingleton();
                }
            }
        }
        return singleton;
    }

    private SimpleSingleton() {}
}
