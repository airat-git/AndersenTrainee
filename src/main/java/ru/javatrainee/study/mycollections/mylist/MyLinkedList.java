package ru.javatrainee.study.mycollections.mylist;

import ru.javatrainee.study.mycollections.mydeque.MyQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyLinkedList <E> implements MyList<E>, MyQueue<E>,Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(last,element,null);
        if (Objects.isNull(element)){
            throw new NullPointerException();
        }
        if (size == 0){
            first = newNode;
            last = newNode;
        }
        else {
            Node<E> saveLast = last;
            last = newNode;
            saveLast.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean offer(E element) {
        return add(element);
    }

    @Override
    public E remove() {
        Node<E> toDelete = first;
        if (Objects.isNull(toDelete)){
            throw new NoSuchElementException();
        }
        Object element = first.item;
        replaceElements(first);
        return (E)element;
    }

    @Override
    public E remove(int index) {
        Node<E> toDelete = catchNode(index);
        if (Objects.nonNull(toDelete)){
            replaceElements(toDelete);
            return toDelete.item;
        }
        return null;
    }
    @Override
    public boolean remove(Object object) {
        Node<E> toDelete = catchNode(object);
        if (Objects.nonNull(toDelete)){
            return replaceElements(toDelete);
        }
        return false;
    }

    @Override
    public E get(int index) {
       return catchNode(index).item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E poll() {
        if (Objects.isNull(first)){
            return null;
        }
        Object element = first.item;
        replaceElements(first);
        return (E) element;
    }

    @Override
    public E peek() {
        return Objects.isNull(first) ? null : first.item;
    }

    @Override
    public void forEach(Consumer action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        if (size > 0) {
            String res = "[";
            for (Node<E> n = first; n != null; n = n.next) {
                res = res + n.item + ", ";
            }
            return res.substring(0, res.length() - 2) + "]";
        }
        return "[]";
    }

    private boolean indexCheck(int index){
        if (index >= size || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        return true;
    }

    private boolean replaceElements(Node<E> toDelete){
        Node<E> prevElement = toDelete.prev;
        Node<E> nextElement = toDelete.next;
        if (size == 1){
            first = null;
            last = null;
        }
        else {
            if (Objects.isNull(prevElement)) {
                nextElement.prev = null;
                first = nextElement;
            } else if (Objects.isNull(nextElement)) {
                prevElement.next = null;
                last = prevElement;
            } else {
                prevElement.next = nextElement;
                nextElement.prev = prevElement;
            }
        }
        size--;
        return true;
    }

    private Node<E> catchNode(Object object){
        for (Node<E> n = first; n!=null;n = n.next){
            if (n.item.equals(object)){
                return n;
            }
        }
        return null;
    }

    private Node<E> catchNode(int index){
        int i = 0;
        if (indexCheck(index)){
            for (Node<E> n = first; n!=null;n = n.next){
                if (i == index){
                    return n;
                }
                i++;
            }
        }
        return null;
    }

    @Override
    public Iterator <E> iterator() {
        Iterator iterator = new Iterator() {

            Node<E> cursor = first;

            @Override
            public boolean hasNext() {
                return Objects.nonNull(cursor);
            }

            @Override
            public Object next() {
                Object element = cursor.item;
                cursor = cursor.next;
                return element;
            }
        };
        return (Iterator<E>) iterator;
    }

    private static class Node<E> {

        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }
}
