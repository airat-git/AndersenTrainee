package ru.javatrainee.study.mymap;

import java.util.Map;
import java.util.Objects;

public class MyHashMap<K,V> implements MyMap<K,V> {

    private int size;

    private Node<K,V>[] array;

    private final int DEFAULT_CAPACITY = 16;

    private int capacity;

    private final int MAX_CAPACITY = 1 << 30;

    private float loadFactor = 0.75f;

    public MyHashMap(){
        array = new Node[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public MyHashMap(int initialCapacity,int initialLoadFactor){
        capacity = initialCapacity;
        loadFactor = initialLoadFactor;
        array = new Node[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(Object key) {
        Node <K,V> node = catchNode(key);
        if (node != null){
            return node.getValue();
        }
        return null;
    }

    @Override
    public V put(Object key, Object value) {
        loadCheck();
        int hash = getHash(key);
        int index = getIndex(hash);
        Node<K,V> newNode = new Node<>(hash,(K)key,(V)value,null);
        Node<K,V> opponent = array[index];
        if (opponent == null){
            array[index] = newNode;
            size++;
            return null;
        }
        else {
            Node <K,V> last = null;
            for (Node<K,V> n = opponent; n != null; n = n.next){
                if (n.hash == hash){
                    if (n.key.equals(key)){
                        n.setValue((V)value);
                        return (V)value;
                    }
                }
                last = n;
            }
            last.next = newNode;
        }
        size++;
        return (V)value;
    }
    @Override
    public V remove(Object key) {
        Node<K,V> node = delete(key);
        V value;
        if (node!=null){
            value = node.getValue();
            size--;
            return value;
        }
        return null;
    }

    private Node<K,V> catchNode(Object key){
        int hash = getHash(key);
        int index = getIndex(hash);
        Node<K,V> node= array[index];
        if (node != null){
            if (node.next == null){
                return node;
            }
            for (Node<K,V> n = node; n!= null; n = n.next){
                if (n.hash == hash){
                    if (n.key.equals(key)){
                        return n;
                    }
                }
            }
        }
        return null;
    }

    private Node<K, V> delete(Object key){
        int hash = getHash(key);
        int index = getIndex(hash);
        Node<K,V> node = array[index];

        if (node!= null){
            Node<K,V> next = node.next;
            if (next == null){
                if (node.hash == hash & node.key.equals(key)){
                    array[index] = null;
                    return node;
                }
            }
            Node<K,V> prev = null;
            for (Node<K,V> n = node; n != null; n = n.next){
                next = n.next;
                if (n.hash == hash){
                    if (n.key.equals(key)){
                        if (prev!=null) {
                            prev.next = next;
                        }
                        else {
                            array[index] = next;
                        }
                        return n;
                    }
                }
                prev = n;
            }
        }
        return null;
    }

    private void loadCheck(){
        float load = size/(float)capacity;
        if (load > loadFactor){
            size = 0;
            capacity = capacity << 1;
            if (capacity > MAX_CAPACITY){
                throw new IllegalStateException();
            }
            Node<K,V>[] oldArr = array;
            array = new Node[capacity];
            for (Node<K,V> nod : oldArr){
                if (nod != null){
                    for (Node<K,V> n = nod; n != null; n = n.next){
                        put( n.getKey(), n.getValue());
                    }
                }
            }
        }
    }

    private int getHash(Object key){
        int hashCode = key.hashCode();
        return hashCode & (capacity - 1);
    }

    private int getIndex(int hash){
        return hash % capacity;
    }

    @Override
    public String toString() {
        String s = "{";
        if (size!=0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    for (Node<K,V> n = array[i]; n != null; n = n.next){
                        s = s + n + ", ";
                    }
                }
            }
            return s.substring(0,s.length()-2) + "}";
        }
        return "{}";
    }

    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        MyHashMap.Node<K,V> next;

        Node(int hash, K key, V value, MyHashMap.Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
}
