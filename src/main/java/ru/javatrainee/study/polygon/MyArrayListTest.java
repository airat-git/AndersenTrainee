package ru.javatrainee.study.polygon;

import ru.javatrainee.study.mylist.MyArrayList;
import ru.javatrainee.study.mylist.MyList;

public class MyArrayListTest {

    public static void main(String[] args) {

        MyList <Integer> myList = new MyArrayList<>();
        System.out.println(myList);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        System.out.println("Мой лист после добавления 10 элементов:");
        System.out.println(myList);
        myList.add(11);
        myList.add(12);
        myList.add(13);
        myList.add(14);
        myList.add(15);
        myList.add(16);
        myList.add(17);
        System.out.println("Мой лист после добавления еще 7 элементов:");
        System.out.println(myList);
        myList.remove(5);
        System.out.println("Мой лист после удаления элемента по индексу '5':");
        System.out.println(myList);
        myList.add(3);
        System.out.println("Мой лист после добавления элемента '3':");
        System.out.println(myList);
        myList.remove(Integer.valueOf(15));
        System.out.println("Мой лист после удаления элемента по значению '15':");
        System.out.println(myList);
        System.out.println("Конечный количество элементов в моем листе (size): " + (myList.size()));
        System.out.println("Элемент под индексом '5'");
        System.out.println(myList.get(5));

    }
}
