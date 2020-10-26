package ru.javatrainee.study.solid.d;

import lombok.AllArgsConstructor;
import ru.javatrainee.study.solid.Order;

@AllArgsConstructor
public class OrderProcessorSender {

    private EmailSender emailSender;
    private SqlRepository sqlRepository;

    public void process(Order order){
        if (order.isValid() && sqlRepository.save(order)){
            emailSender.sendEmail(order);
        }
    }
}
