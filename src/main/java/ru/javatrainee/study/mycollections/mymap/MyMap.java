package ru.javatrainee.study.mycollections.mymap;

public interface MyMap <K,V> {

    int size();

    V get(Object key);

    V put(K key,V value);

    V remove(Object key);
}
