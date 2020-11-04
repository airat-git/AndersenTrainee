package ru.javatrainee.study.mycollections.mydeque;

import ru.javatrainee.study.mycollections.MyCollection;

public interface MyQueue <E> extends MyCollection<E>{

    E poll();

    E peek();

    boolean add(E element);

    E remove();

    boolean offer(E element);
}
