package ru.javatrainee.study.mylist;

import ru.javatrainee.study.MyCollection;

public interface MyList<E> extends MyCollection <E> {

    E remove(int index);

    E get(int index);
}
