package ru.javatrainee.study.mycollections.mylist;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList <E> implements MyList<E> {

    private Object [] array;
    private int capacity = 10;
    private int size = 0;

    public MyArrayList() {
        array = new Object[capacity];
    }

    public MyArrayList(int initialCapacity){
        capacity = initialCapacity;
        array = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        if (size + 1 > capacity){
            int newCapacity = ((capacity*3)/2) + 1;
            Object[] newArr = Arrays.copyOf(array,(newCapacity));
            newArr[size] = element;
            array = newArr;
            capacity = newCapacity;
        }
        else {
            for (int i = 0; i < array.length;i++){
                if (Objects.isNull(array[i])){
                    array[i] = element;
                    break;
                }
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < array.length;i++){
            if (Objects.nonNull(array[i]) && array[i].equals(object)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index,size);
        Object element = array[index];
        if (index == size-1){
            array[size-1] = null;
        }
        else {
            if (size - index >= 0) {
                System.arraycopy(array, index + 1, array, index, size - index);
            }
        }
        size--;
        return (E)element;
    }

    @Override
    public E get(int index) {
        return (E)array[index];
    }

    @Override
    public String toString() {
        if (size > 0) {
            String res = "[";
            for (Object o : array) {
                if (Objects.nonNull(o)) {
                    res = res + o + ", ";
                }
            }
            return res.substring(0, res.length() - 2) + "]";
        }
        return "[]";
    }
}
