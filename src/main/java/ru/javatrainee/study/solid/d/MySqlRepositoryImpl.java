package ru.javatrainee.study.solid.d;

import ru.javatrainee.study.solid.MySqlConnection;
import ru.javatrainee.study.solid.Order;

public class MySqlRepositoryImpl implements SqlRepository {

    public boolean save(Order order){
        MySqlConnection connection = new MySqlConnection("DB");
        return true;
    }
}
