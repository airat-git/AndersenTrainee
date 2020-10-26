package ru.javatrainee.study.solid.d;

import ru.javatrainee.study.solid.Order;

public class EmailSenderImpl implements EmailSender {

    public void sendEmail(Order order){
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();
    }
}
