package ru.javatrainee.study.mycollections.mydeque;

public interface MyDeque<E> extends MyQueue<E> {

    void addFirst(E element);

    E peekLast();
}
