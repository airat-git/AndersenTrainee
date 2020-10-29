package ru.javatrainee.study.solid.s;

import ru.javatrainee.study.solid.Order;

public class ConfirmationEmailSender {

    public void sendEmail(Order order){
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();
    }
}
