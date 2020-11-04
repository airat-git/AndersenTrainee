package ru.javatrainee.study.mycollections.polygon;

import ru.javatrainee.study.mycollections.mylist.MyLinkedList;
import java.util.Iterator;

public class MyLinkedListTest {

    public static void main(String[] args) {

        MyLinkedList<String> myList = new MyLinkedList();
        myList.remove("a");
        System.out.println("Мой лист пустой:");
        System.out.println(myList);
        myList.add("A");
        System.out.println("Мой лист после добавления одного элемента 'A':");
        System.out.println(myList);
        System.out.println(myList.size());
        myList.remove("A");
        System.out.println("Мой лист после удаления единственного элемента:");
        System.out.println(myList);
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("E");
        myList.add("F");
        System.out.println("Мой лист после добавления 6 элементов:");
        System.out.println(myList);
        myList.add("G");
        myList.add("H");
        myList.add("I");
        System.out.println("Мой лист после добавления еще 3 элементов:");
        System.out.println(myList);
        System.out.println("6 элемент моего листа (по индексу):");
        System.out.println(myList.get(6));
        myList.remove(4);
        System.out.println("Мой лист после удаления элемента по индексу '4':");
        System.out.println(myList);
        myList.remove("F");
        System.out.println("Мой лист после удаления элемента 'F':");
        System.out.println(myList);
        myList.add("hi!");
        System.out.println("Мой лист после добавления элемента 'hi':");
        System.out.println(myList);
        myList.poll();
        System.out.println("Мой лист после метода poll():");
        System.out.println(myList);
        System.out.println("Итерация по элементам листа:");
        Iterator iterator = myList.iterator();
        int i = 1;
        while (iterator.hasNext()){
            System.out.printf("Элемент №%d:",i);
            System.out.println(iterator.next());
            i++;
        }
    }
}
