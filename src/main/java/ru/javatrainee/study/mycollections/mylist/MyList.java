package ru.javatrainee.study.mycollections.mylist;

import ru.javatrainee.study.mycollections.MyCollection;

public interface MyList<E> extends MyCollection <E> {

    E remove(int index);

    E get(int index);
}
