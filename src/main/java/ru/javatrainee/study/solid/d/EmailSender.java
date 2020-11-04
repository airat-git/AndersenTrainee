package ru.javatrainee.study.solid.d;

import ru.javatrainee.study.solid.Order;

public interface EmailSender {

    void sendEmail(Order order);
}
