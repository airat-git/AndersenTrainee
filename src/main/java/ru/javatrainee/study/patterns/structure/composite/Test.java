package ru.javatrainee.study.patterns.structure.composite;

public class Test {

    public static void main(String[] args) {

        Book detective = new Detective();
        Book fairyTale = new FairyTail();
        CompositeBooks compositeBooks = new CompositeBooks();
        compositeBooks.addBook(detective);
        compositeBooks.addBook(fairyTale);
        compositeBooks.read();
    }
}
