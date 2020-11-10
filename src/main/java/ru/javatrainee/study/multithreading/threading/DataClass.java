package ru.javatrainee.study.multithreading.threading;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Getter
public class DataClass {

    private int value;
    public static ConcurrentMap<String,String> changeLog = new ConcurrentHashMap<>();

    public void setNewValue(int value) {
        this.value = value;
    }
}
