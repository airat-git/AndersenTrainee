package ru.javatrainee.study.solid.o;

import ru.javatrainee.study.solid.Order;
import ru.javatrainee.study.solid.SimpleOrderProcessor;


public class OrderProcessorModernized extends SimpleOrderProcessor {

    @Override
    public void process(Order order) {
        beforeProcessing();
        super.process(order);
        postProcessing();
    }

    public void beforeProcessing(){
        System.out.println("Some method before processing");
    }

    public void postProcessing(){
        System.out.println("Some method after processing");
    }
}
