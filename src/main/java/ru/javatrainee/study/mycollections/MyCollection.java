package ru.javatrainee.study.mycollections;

public interface MyCollection <E> {

    int size();

    boolean add(E element);

    boolean remove(Object object);
}
