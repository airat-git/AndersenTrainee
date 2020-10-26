package ru.javatrainee.study.patterns.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeBooks implements Book {

    private List<Book> components = new ArrayList<>();

    public void addBook(Book book){
        components.add(book);
    }

    @Override
    public void read() {
        for (Book book : components){
            book.read();
        }
    }
}
