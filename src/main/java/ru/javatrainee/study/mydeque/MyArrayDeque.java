package ru.javatrainee.study.mydeque;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayDeque<E> implements MyDeque<E> {

    private Object[] array;
    
    private int capacity = 16;
    
    private int size = 0;
    
    private int head;
    
    private int tail;

    public MyArrayDeque(int initialCapacity) {
        capacity = initialCapacity;
        array = new Object[capacity];
    }
    
    public MyArrayDeque(){
        array = new Object[capacity];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        if (element == null){
            throw new NullPointerException();
        }
        if (offer(element)){
            return true;
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addFirst(E element) {
        if (size + 1 > capacity){
            throw new IllegalStateException();
        }
        Object saveNext;
        for (int i = size; i > 0;i--){
            saveNext = array[i-1];
            array[i-1] = array[i];
            array[i] = saveNext;
        }
        array[0] = element;
        head = 0;
        size++;
        if (size == 1){
            tail = head;
        }
        else {
            tail++;
        }
    }

    @Override
    public E remove() {
        if (size == 0){
            throw new NoSuchElementException();
        }
        Object element = array[head];
        delete(head);
        return (E)element;
    }
    
    @Override
    public E poll() {
        if (size != 0){
            return delete(head);
        }
        return null;
    }

    @Override
    public E peek() {
        if (size != 0){
            return (E) array[head];
        }
        return null;
    }
    @Override
    public E peekLast() {
        if (size != 0){
            return (E)array[tail];
        }
        return null;
    }

    @Override
    public boolean offer(E element) {
        if (size + 1 > capacity){
            return false;
        }
        for (int i = 0; i < array.length;i++){
            if (array[i] == null){
                array[i] = element;
                size++;
                if (size == 1){
                    head = i;
                }
                tail = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (size > 0) {
            String res = "[";
            for (Object o : array) {
                if (o != null) {
                    res = res + o + ", ";
                }
            }
            return res.substring(0, res.length() - 2) + "]";
        }
        return "[]";
    }

    private E delete(int index) {
        Objects.checkIndex(index,size);
        Object element = array[index];
        if (size - 1 >= 0) System.arraycopy(array, 1, array, 0, size - 1);
        array[size-1] = null;
        size--;
        tail = size-1;
        return (E)element;
    }
}
