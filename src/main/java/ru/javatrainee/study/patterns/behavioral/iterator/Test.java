package ru.javatrainee.study.patterns.behavioral.iterator;

public class Test {

    public static void main(String[] args) {
        Container c = new SpecialContainer();
        Iterator iterator = c.getIterator();
        while (iterator.hasNext()){
            System.out.println((String) iterator.next());
        }
    }
}
