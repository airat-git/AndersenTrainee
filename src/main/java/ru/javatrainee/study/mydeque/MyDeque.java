package ru.javatrainee.study.mydeque;

public interface MyDeque<E> extends MyQueue<E> {

    void addFirst(E element);

    E peekLast();
}
