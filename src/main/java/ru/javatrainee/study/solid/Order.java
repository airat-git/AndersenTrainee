package ru.javatrainee.study.solid;

import lombok.Getter;
import java.util.ArrayList;

@Getter
public class Order {

    private String customerName;
    private String customerEmail;
    private ArrayList<Item> items = new ArrayList<Item>();

    public boolean isValid(){
        return true;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

}
