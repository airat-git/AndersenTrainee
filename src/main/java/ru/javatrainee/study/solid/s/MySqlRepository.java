package ru.javatrainee.study.solid.s;

import ru.javatrainee.study.solid.MySqlConnection;
import ru.javatrainee.study.solid.Order;

public class MySqlRepository {

    public boolean save(Order order){
        MySqlConnection connection = new MySqlConnection("DB");
        return true;
    }

}
