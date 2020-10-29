package ru.javatrainee.study.solid.s;

import ru.javatrainee.study.solid.Order;

public class OrderProcessorSender {

    public void process(Order order){
        ConfirmationEmailSender confirmationEmailSender = new ConfirmationEmailSender();
        MySqlRepository mySqlRepository = new MySqlRepository();
        if (order.isValid() && mySqlRepository.save(order)){
            confirmationEmailSender.sendEmail(order);
        }
    }

}
