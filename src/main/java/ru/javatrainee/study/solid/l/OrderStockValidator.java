package ru.javatrainee.study.solid.l;

import ru.javatrainee.study.solid.Item;
import ru.javatrainee.study.solid.Order;

public class OrderStockValidator {

    public boolean isValid(Order order){
        for (Item item : order.getItems()){
            if(!item.isInStock()){
                return false;
            }
        }
        return true;
    }
}
