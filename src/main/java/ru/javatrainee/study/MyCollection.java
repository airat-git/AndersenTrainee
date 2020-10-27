package ru.javatrainee.study;

public interface MyCollection <E> {

    int size();

    boolean add(E element);

    boolean remove(Object object);
}
