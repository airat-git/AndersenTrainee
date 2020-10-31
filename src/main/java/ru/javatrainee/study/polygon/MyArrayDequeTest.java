package ru.javatrainee.study.polygon;

import ru.javatrainee.study.mydeque.MyArrayDeque;
import ru.javatrainee.study.mydeque.MyDeque;

public class MyArrayDequeTest {

    public static void main(String[] args) {

        MyDeque<String> myQueue = new MyArrayDeque<>();
        System.out.println("Моя очередь пуста:");
        System.out.println(myQueue);
        myQueue.add("A");
        System.out.println("Моя очередь после добавления одного элемента 'A':");
        System.out.println(myQueue);
        System.out.println("Размер моей очереди:");
        System.out.println(myQueue.size());
        myQueue.remove();
        System.out.println("Моя очередь после удаления одного элемента с начала очереди:");
        System.out.println(myQueue);
        System.out.println("Размер моей очереди:");
        System.out.println(myQueue.size());
        myQueue.add("A");
        myQueue.add("B");
        myQueue.add("C");
        myQueue.add("D");
        myQueue.add("E");
        myQueue.add("F");
        System.out.println("Моя очередь после добавления 6 элементов:");
        System.out.println(myQueue);
        System.out.println("Размер моей очереди:");
        System.out.println(myQueue.size());
        System.out.println("Первый элемент в моей в очереди:");
        System.out.println(myQueue.peek());
        System.out.println("Последний элемент в моей очереди:");
        System.out.println(myQueue.peekLast());
        System.out.println("Удаление первого элемента в моей очереди с возвратом элемента методом poll(): " + myQueue.poll());
        System.out.println("Моя очередь после вызова метод poll():");
        System.out.println(myQueue);
        System.out.println("Повторный вызов метода poll(): " + myQueue.poll());
        System.out.println(myQueue);
        System.out.println("Размер моей очереди:");
        System.out.println(myQueue.size());
        System.out.println("Добавление элемента 'first' в начало моей очереди:");
        myQueue.addFirst("first");
        System.out.println("Моя очередь после добавления элемента 'first' в начало моей очереди:");
        System.out.println(myQueue);
        System.out.println("Добавление элемента 'new first' в начало моей очереди:");
        myQueue.addFirst("new first");
        System.out.println("Моя очередь после добавления элемента 'new first' в начало моей очереди:");
        System.out.println(myQueue);
        System.out.println("Размер моей очереди:");
        System.out.println(myQueue.size());
    }
}
