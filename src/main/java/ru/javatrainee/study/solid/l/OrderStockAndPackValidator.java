package ru.javatrainee.study.solid.l;

import ru.javatrainee.study.solid.Item;
import ru.javatrainee.study.solid.Order;

public class OrderStockAndPackValidator extends OrderStockValidator {

    @Override
    public boolean isValid(Order order){
        for (Item item : order.getItems()){
            if(!item.isInStock() && !item.isPacked()){
                return false;
            }
        }
        return true;
    }
}
