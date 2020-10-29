package ru.javatrainee.study.solid.d;

import ru.javatrainee.study.solid.Order;

public interface SqlRepository {

    boolean save(Order order);
}
