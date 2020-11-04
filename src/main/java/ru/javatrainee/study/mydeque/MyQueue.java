package ru.javatrainee.study.mydeque;

import ru.javatrainee.study.MyCollection;

public interface MyQueue <E> extends MyCollection<E>{

    E poll();

    E peek();

    boolean add(E element);

    E remove();

    boolean offer(E element);
}
